package com.coderefer.currencyconversionservice.controller;

import com.coderefer.currencyconversionservice.entity.CurrencyConversion;
import com.coderefer.currencyconversionservice.exception.CurrencyConversionException;
import com.coderefer.currencyconversionservice.response.CurrencyConversionResponse;
import com.coderefer.currencyconversionservice.utils.CurrencyConversionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity
    ) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionResponse> responseEntity = restTemplate.getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionResponse.class,
                uriVariables);
        CurrencyConversionResponse response = responseEntity.getBody();
        if (response == null) {
            throw new CurrencyConversionException("Unable to convert currency");
        }
        return new CurrencyConversion(response.getId(),
                response.getFrom(),
                response.getTo(),
                quantity,
                response.getConversionMultiple(),
                CurrencyConversionUtils
                        .calculateTotalAmount(response.getConversionMultiple(), quantity),
                ""
        );
    }
}
