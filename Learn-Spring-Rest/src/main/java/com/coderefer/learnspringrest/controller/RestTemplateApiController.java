package com.coderefer.learnspringrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestTemplateApiController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8081/common/api/v1/students";

    @GetMapping("/rest-template/students")
    public List<Object> getStudents() {
        Object[] students = restTemplate.getForObject(URL, Object[].class);
        return Arrays.asList(students);
    }
}
