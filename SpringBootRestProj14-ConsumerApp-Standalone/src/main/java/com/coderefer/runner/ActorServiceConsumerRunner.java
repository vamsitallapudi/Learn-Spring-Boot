package com.coderefer.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

//@Component
public class ActorServiceConsumerRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = "http://localhost:4041/actor/wish/{id}/{name}";

        ResponseEntity<String> response =
                restTemplate.getForEntity(serviceUrl,
                        String.class,
                        Map.of("name", "Krishna", "id", "101"));

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }
}
