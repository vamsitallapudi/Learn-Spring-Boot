package com.coderefer.learnspringsecurity.controller;

import com.coderefer.learnspringsecurity.entity.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("common/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENT_LIST = Arrays.asList(
      new Student(1, "Vamsi"),
      new Student(2, "Krishna"),
      new Student(3, "Tallapudi")
    );

    @GetMapping(path = "{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        return STUDENT_LIST.stream()
                .filter(s -> s.id.equals(id))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student with " + id + " doesn't exist"));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENT_LIST;
    }
}
