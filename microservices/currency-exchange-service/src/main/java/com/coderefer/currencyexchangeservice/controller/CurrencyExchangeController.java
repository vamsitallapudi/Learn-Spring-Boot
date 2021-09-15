package com.coderefer.currencyexchangeservice.controller;

import com.coderefer.currencyexchangeservice.entity.CurrencyExchange;
import com.coderefer.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeService exchangeService;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from, @PathVariable String to
    ) throws RuntimeException {
        Optional<CurrencyExchange> currencyExchangeOptional = exchangeService.findCurrencyExchange(from, to);
        if (currencyExchangeOptional.isPresent()) {
            return currencyExchangeOptional.get();
        } else {
            throw new RuntimeException();
        }
    }
}



