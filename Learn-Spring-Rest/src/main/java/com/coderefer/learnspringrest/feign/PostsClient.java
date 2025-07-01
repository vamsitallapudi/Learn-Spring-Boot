package com.coderefer.learnspringrest.feign;

import com.coderefer.learnspringrest.entity.Post;
import com.coderefer.learnspringrest.entity.PostV2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(url = "https://flourishing-starlight-8e274f.netlify.app", name = "posts-service")
public interface PostsClient {

    @GetMapping("/v1/posts.json")
    List<Post> getPosts();

    @GetMapping("/v2/posts.json")
    List<PostV2> getPostsV2();
}
