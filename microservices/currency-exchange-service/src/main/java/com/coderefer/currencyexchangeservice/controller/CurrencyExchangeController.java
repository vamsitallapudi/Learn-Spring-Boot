package com.coderefer.currencyexchangeservice.controller;

import com.coderefer.currencyexchangeservice.entity.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

import org.springframework.core.env.Environment;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment env;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from, @PathVariable String to
    ) {
        String port = env.getProperty("local.server.port");
        return new CurrencyExchange(1000L,from, to, BigDecimal.valueOf(50), port);
    }
}



