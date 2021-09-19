package com.coderefer.currencyexchangeservice.controller;

import com.coderefer.currencyexchangeservice.entity.CurrencyExchange;
import com.coderefer.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeService exchangeService;
    @Autowired
    private Environment env;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from, @PathVariable String to
    ) throws Exception {
        Optional<CurrencyExchange> currencyExchangeOptional = exchangeService.findCurrencyExchange(from, to);
        if (currencyExchangeOptional.isPresent()) {
            CurrencyExchange exchange = currencyExchangeOptional.get();
            String port = env.getProperty("local.server.port");
            exchange.setEnvironment(port);
            return exchange;
        } else {
            throw new Exception("Currency Exchange Not found");
        }
    }
}



