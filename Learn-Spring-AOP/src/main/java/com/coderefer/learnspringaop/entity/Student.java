package com.coderefer.learnspringaop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(
         generator = "student_sequence",
         strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(name = "stud_seq", sequenceName = "student_sequence")

    private int id;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
