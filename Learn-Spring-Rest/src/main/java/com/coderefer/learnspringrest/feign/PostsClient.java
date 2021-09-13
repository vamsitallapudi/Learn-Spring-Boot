package com.coderefer.learnspringrest.feign;


import com.coderefer.learnspringrest.entity.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient(url = "https://jsonplaceholder.typicode.com",name = "posts-service")
public interface PostsClient {

    @GetMapping("/posts")
    List<PostResponse> getPosts();
}
