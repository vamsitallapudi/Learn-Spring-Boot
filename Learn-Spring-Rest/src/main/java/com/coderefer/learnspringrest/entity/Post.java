package com.coderefer.learnspringrest.entity;

import lombok.Data;

@Data
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
