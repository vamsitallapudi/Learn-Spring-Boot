package com.coderefer.learnspringrest.controller;

import com.coderefer.learnspringrest.config.ApiVersionConfig;
import com.coderefer.learnspringrest.entity.Post;
import com.coderefer.learnspringrest.entity.PostV2;
import com.coderefer.learnspringrest.feign.PostsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiVersionConfig.API_BASE_PATH)
public class PostsApiController {

    @Autowired
    private PostsClient postsClient;

    // URL Based Versioning - V1
    @GetMapping("/v1/posts")
    public ResponseEntity<List<Post>> getPostsV1() {
        try {
            log.info("Fetching V1 posts");
            List<Post> posts = postsClient.getPosts();
            log.info("Received {} V1 posts", posts.size());
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            log.error("Error fetching V1 posts", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    // URL Based Versioning - V2
    @GetMapping("/v2/posts")
    public ResponseEntity<List<PostV2>> getPostsV2() {
        try {
            log.info("Fetching V2 posts");
            List<PostV2> posts = postsClient.getPostsV2();
            log.info("Received {} V2 posts", posts.size());
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            log.error("Error fetching V2 posts", e);
            return ResponseEntity.internalServerError().build();
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