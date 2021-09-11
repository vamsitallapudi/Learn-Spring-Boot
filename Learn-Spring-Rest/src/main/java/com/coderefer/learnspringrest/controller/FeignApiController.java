package com.coderefer.learnspringrest.controller;

import com.coderefer.learnspringrest.entity.Student;
import com.coderefer.learnspringrest.feign.FeignClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeignApiController implements FeignClient {
    @Override
    public List<Student> getStudents() {
        return new ArrayList<>();
    }
}
