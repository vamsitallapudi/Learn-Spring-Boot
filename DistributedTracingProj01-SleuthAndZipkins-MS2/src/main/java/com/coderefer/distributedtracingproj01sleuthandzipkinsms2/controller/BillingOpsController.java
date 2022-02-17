package com.coderefer.distributedtracingproj01sleuthandzipkinsms2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BillingOpsController {

    @Autowired
    private RestTemplate template;
    Logger logger = LoggerFactory.getLogger(BillingOpsController.class);

    @GetMapping("/billing")
    private String getBilling() {
        logger.info("Welcome to Billing Section!");
        String resp = template.getForObject("http://localhost:9094/payment", String.class);
        logger.info("Back to Billing module");
        return resp;
    }
}
