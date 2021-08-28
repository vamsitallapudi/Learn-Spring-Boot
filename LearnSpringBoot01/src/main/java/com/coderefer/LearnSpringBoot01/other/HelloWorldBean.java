package com.coderefer.LearnSpringBoot01.other;

import lombok.Data;

@Data
public class HelloWorldBean {
    private String message;
    public HelloWorldBean(String message) {
        this.message = message;
    }
}
