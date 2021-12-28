package com.coderefer.runner;

import com.coderefer.entity.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = "http://localhost:4041/actor/wish/{id}/{name}";

//        invoke service method / operation using exchange(-,-,-) method

        ResponseEntity<String> response =
                restTemplate.exchange(serviceUrl,
                        HttpMethod.GET,
                        // no body for GET mode, and we don't want to pass any header values
                        null,
                        String.class,
                        1234,
                        "Shiva");

        System.out.println("####################################");
        System.out.println("Status code -> " + response.getStatusCode());
        System.out.println("Status code value -> " +response.getStatusCodeValue());
        System.out.println("Headers -> " +response.getHeaders());
        System.out.println("Body -> " +response.getBody());
        System.out.println("####################################");

//        converting JSON text response(body) to java class object / model class obj / entity class obj
//        using Jackson API
        String jsonBody = response.getBody();
//        create Object Mapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(jsonBody, Actor.class);
    }
}
