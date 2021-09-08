package com.coderefer.learnspringsecurity.student;

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
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        students.add(student);
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer id) {
        students.removeIf(student -> student.getId().equals(id));
        System.out.println(id);
    }
    @PutMapping(path = "{studentId}")
    public Student updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        students.removeIf(s -> s.getId().equals(studentId));
        students.add(student);
        return student;
    }


}
