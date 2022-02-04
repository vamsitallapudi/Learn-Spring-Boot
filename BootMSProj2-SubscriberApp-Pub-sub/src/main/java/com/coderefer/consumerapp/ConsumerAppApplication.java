package com.coderefer.consumerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ConsumerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAppApplication.class, args);
    }

}
