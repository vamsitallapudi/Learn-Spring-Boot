package com.coderefer.microservices.limitsservice.controller;

import com.coderefer.microservices.limitsservice.entity.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(1,1000);
    }
}