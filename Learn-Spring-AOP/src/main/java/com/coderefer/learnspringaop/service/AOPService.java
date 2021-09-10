package com.coderefer.learnspringaop.service;

import com.coderefer.learnspringaop.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class AOPService {

    public void hello() {
        System.out.println("Hello World!");
    }

    public void pause() {
        System.out.println("I will be back!");
    }

    public Student myStud() {
        Student student = new Student();
        student.setId(1);
        student.setName("Vamsi");
        return student;
    }

}
