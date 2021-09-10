package com.coderefer.learnspringaop.service;

import org.springframework.stereotype.Service;

@Service
public class AOPService {

    public void hello() {
        System.out.println("Hello World!");
    }

    public void pause() {
        System.out.println("I will be back!");
    }

}
