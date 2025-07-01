package com.coderefer.learnspringrest.controller;

import com.coderefer.learnspringrest.config.ApiVersionConfig;
import com.coderefer.learnspringrest.entity.Post;
import com.coderefer.learnspringrest.entity.PostV2;
import com.coderefer.learnspringrest.feign.PostsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import jakarta.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(ApiVersionConfig.API_BASE_PATH)
public class PostsApiController {
    private static final Logger log = LoggerFactory.getLogger(PostsApiController.class);

    @Autowired
    private PostsClient postsClient;

    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    private Bucket resolveBucket(String ip) {
        return buckets.computeIfAbsent(ip, k -> Bucket4j.builder()
                .addLimit(Bandwidth.classic(10, Refill.intervally(10, Duration.ofMinutes(1))))
                .build());
    }

    private String getClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

    // URL Based Versioning - V1
    @GetMapping("/v1/posts")
    public ResponseEntity<List<Post>> getPostsV1(HttpServletRequest request) {
        String ip = getClientIP(request);
        Bucket bucket = resolveBucket(ip);
        if (bucket.tryConsume(1)) {
            try {
                log.info("Fetching V1 posts");
                List<Post> posts = postsClient.getPosts();
                log.info("Received {} V1 posts", posts.size());
                return ResponseEntity.ok(posts);
            } catch (Exception e) {
                log.error("Error fetching V1 posts", e);
                return ResponseEntity.internalServerError().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }
    }

    // URL Based Versioning - V2
    @GetMapping("/v2/posts")
    public ResponseEntity<List<PostV2>> getPostsV2(HttpServletRequest request) {
        String ip = getClientIP(request);
        Bucket bucket = resolveBucket(ip);
        if (bucket.tryConsume(1)) {
            try {
                log.info("Fetching V2 posts");
                List<PostV2> posts = postsClient.getPostsV2();
                log.info("Received {} V2 posts", posts.size());
                return ResponseEntity.ok(posts);
            } catch (Exception e) {
                log.error("Error fetching V2 posts", e);
                return ResponseEntity.internalServerError().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }
    }

    // Header Based Versioning
    @GetMapping(value = "/posts")
    public ResponseEntity<List<? extends Post>> getPosts(
            @RequestHeader("X-API-Version") String apiVersion) {
        try {
            log.info("Fetching posts with version: {}", apiVersion);
            if (apiVersion.equalsIgnoreCase("1")) {
                List<Post> posts = postsClient.getPosts();
                log.info("Received {} V1 posts", posts.size());
                return ResponseEntity.ok(posts);
            } else if (apiVersion.equalsIgnoreCase("2")) {
                List<PostV2> posts = postsClient.getPostsV2();
                log.info("Received {} V2 posts", posts.size());
                return ResponseEntity.ok(posts);
            } else {
                log.warn("Invalid API version requested: {}", apiVersion);
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            log.error("Error fetching posts with version: {}", apiVersion, e);
            return ResponseEntity.internalServerError().build();
        }
    }
}