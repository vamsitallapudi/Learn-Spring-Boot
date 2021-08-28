package com.coderefer.LearnSpringBoot01.other;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String getHelloWorld() {
        return "Hello World";
    }


    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/{name}")
    public HelloWorldBean pathParamEg(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello %s, Hope you have a great day!", name));
    }

}
