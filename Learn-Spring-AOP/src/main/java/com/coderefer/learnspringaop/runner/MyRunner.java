package com.coderefer.learnspringaop.runner;

import com.coderefer.learnspringaop.service.AOPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {

    @Autowired
    private AOPService service;

    @Override
    public void run(String... args) throws Exception {
        service.hello();
        service.pause();
        service.myStud();
    }
}
