package com.coderefer.learnspringrest.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PostV2 extends Post {
    // Additional fields for V2
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> tags;
    private Integer likes;
    private Integer views;
    private String category;
    private Boolean isPublished;
    private String featuredImageUrl;
    private List<String> comments;
} 