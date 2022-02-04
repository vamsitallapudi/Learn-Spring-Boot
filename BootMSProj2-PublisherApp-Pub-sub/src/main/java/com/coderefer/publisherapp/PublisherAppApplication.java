package com.coderefer.publisherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PublisherAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublisherAppApplication.class, args);
    }

}
