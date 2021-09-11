package com.coderefer.learnspringrest.feign;


import com.coderefer.learnspringrest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@org.springframework.cloud.openfeign.FeignClient(name = "api-service")
public interface FeignClient {

    @GetMapping("/common/api/v1/students")
    List<Student> getStudents();
}
