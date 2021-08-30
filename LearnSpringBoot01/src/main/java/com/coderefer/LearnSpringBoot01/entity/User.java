package com.coderefer.LearnSpringBoot01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;
    @Past(message = "Birth date shouldn't be a future date")
    private Date birthDate;
}
