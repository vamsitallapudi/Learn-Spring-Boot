package com.coderefer.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorPostServiceConsumerRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = "http://localhost:4041/actor/postActor";

        String jsonBody = "{\"aId\": 1, \"name\": \"Vamsi\", \"age\": 30.0, \"type\": \"programmer\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonBody,headers);
        ResponseEntity<String> response = restTemplate.postForEntity(serviceUrl, request, String.class);


        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }
}
