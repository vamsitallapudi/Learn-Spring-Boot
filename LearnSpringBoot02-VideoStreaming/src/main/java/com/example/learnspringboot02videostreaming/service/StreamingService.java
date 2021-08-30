package com.example.learnspringboot02videostreaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {
    @Autowired
    private ResourceLoader resourceLoader;

    public static final String FORMAT = "classpath:video/%s.mp4";

    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(()-> resourceLoader.getResource(String.format(FORMAT, title)));
    }

}
