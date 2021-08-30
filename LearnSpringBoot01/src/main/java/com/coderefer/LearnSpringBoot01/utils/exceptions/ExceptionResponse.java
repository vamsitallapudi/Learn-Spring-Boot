package com.coderefer.LearnSpringBoot01.utils.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private final Date date;
    private final String message;
    private final String details;
}
