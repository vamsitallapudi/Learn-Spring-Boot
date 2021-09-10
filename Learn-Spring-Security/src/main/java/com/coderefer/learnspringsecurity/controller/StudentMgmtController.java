package com.coderefer.learnspringsecurity.controller;

import com.coderefer.learnspringsecurity.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentMgmtController {

    private final List<Student> students = new ArrayList<>();

    public StudentMgmtController() {
        students.add(new Student(1, "Vamsi"));
        students.add(new Student(2, "Krishna"));
        students.add(new Student(3, "Tallapudi"));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return students;
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public Student getStudent(@PathVariable Integer id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElseThrow();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public ResponseEntity<Student> registerNewStudent(@RequestBody Student student) {
        students.add(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer id) {
        students.removeIf(student -> student.getId().equals(id));
        System.out.println(id);
    }
    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public Student updateStudent(@PathVariable("studentId") Integer studentId,
                                 @RequestBody Student student) {
        students.removeIf(s -> s.getId().equals(studentId));
        students.add(student);
        return student;
    }


}
