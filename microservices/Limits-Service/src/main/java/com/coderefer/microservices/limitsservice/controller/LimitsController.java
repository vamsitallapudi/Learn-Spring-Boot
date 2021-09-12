package com.coderefer.microservices.limitsservice.controller;

import com.coderefer.microservices.limitsservice.config.LimitsConfig;
import com.coderefer.microservices.limitsservice.entity.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    private LimitsConfig limitsConfig;
    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(limitsConfig.getMinimum(), limitsConfig.getMaximum());
    }
}
