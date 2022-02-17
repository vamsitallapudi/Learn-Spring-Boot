package com.coderefer.distributedtracingproj01sleuthandzipkinsms1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingOpsController {

    @Autowired
    private RestTemplate template;
    Logger logger = LoggerFactory.getLogger(ShoppingOpsController.class);

    @GetMapping("/shopping")
    private String shopping() {
        logger.info("Welcome to shopping Section!");
        String resp = template.getForObject("http://localhost:9093/billing", String.class);
        logger.info("Back to shopping module");
        return resp;
    }
}
