package com.coderefer.LearnSpringBoot01.controller.helloWorld;

import com.coderefer.LearnSpringBoot01.other.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-international")
    public String getHelloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message", null, "hello world!!",  LocaleContextHolder.getLocale());
    }


    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/welcome/{name}")
    public HelloWorldBean pathParamEg(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello %s, Hope you have a great day!", name));
    }

}
