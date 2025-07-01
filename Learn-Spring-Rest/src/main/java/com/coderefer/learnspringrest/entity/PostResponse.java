package com.coderefer.learnspringrest.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "post_responses")
public class PostResponse {
    @Id
    private String id;
    private Integer userId;
    private String title;
    private String body;
}
