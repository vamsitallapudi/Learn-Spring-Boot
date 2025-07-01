package com.coderefer.learnspringrest.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PostsClientErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
            return new ResponseStatusException(
                HttpStatus.valueOf(response.status()),
                "Error fetching posts: Client error"
            );
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new ResponseStatusException(
                HttpStatus.valueOf(response.status()),
                "Error fetching posts: Server error"
            );
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
} 