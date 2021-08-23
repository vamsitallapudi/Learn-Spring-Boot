package com.coderefer.learnconcepts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Album {
    private Integer userId;
    private Integer id;
    private String title;
}
