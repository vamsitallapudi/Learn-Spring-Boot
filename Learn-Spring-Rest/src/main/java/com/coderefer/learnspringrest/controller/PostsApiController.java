package com.coderefer.learnspringrest.controller;

import com.coderefer.learnspringrest.entity.PostResponse;
import com.coderefer.learnspringrest.feign.PostsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostsApiController {

    @Autowired
    private PostsClient postsClient;

    @GetMapping("/posts")
    public List<PostResponse> getPosts() {
        return postsClient.getPosts();
    }

}
