package com.coderefer.LearnSpringBoot01.utils.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private Date date;
    private String message;
    private String details;
}
