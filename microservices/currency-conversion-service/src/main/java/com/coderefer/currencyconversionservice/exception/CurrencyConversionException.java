package com.coderefer.currencyconversionservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencyConversionException extends RuntimeException {
    public CurrencyConversionException(String s) {
        super(s);
    }
}
