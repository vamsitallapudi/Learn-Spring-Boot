package com.coderefer.learnconcepts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LearnConceptsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnConceptsApplication.class, args);
    }

}
