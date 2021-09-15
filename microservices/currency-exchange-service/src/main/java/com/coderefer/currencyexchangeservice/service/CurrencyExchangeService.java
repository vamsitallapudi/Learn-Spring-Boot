package com.coderefer.currencyexchangeservice.service;

import com.coderefer.currencyexchangeservice.entity.CurrencyExchange;
import com.coderefer.currencyexchangeservice.repo.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyExchangeService {
    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    public Optional<CurrencyExchange> findCurrencyExchange(String from, String to) {
        return currencyExchangeRepo.findByFromAndTo(from, to);
    }
}
