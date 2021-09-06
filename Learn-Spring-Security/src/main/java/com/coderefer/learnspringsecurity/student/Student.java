package com.coderefer.learnspringsecurity.student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    public final Integer id;
    private final String name;
}
