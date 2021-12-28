package com.coderefer.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumerRunnerPostData implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        RestTemplate template = new RestTemplate();
        String jsonBody =  "{\"aId\": 1001, \"name\": \"Vamsi\", \"age\": 30.0, \"type\": \"actor\" }";
    }
}
