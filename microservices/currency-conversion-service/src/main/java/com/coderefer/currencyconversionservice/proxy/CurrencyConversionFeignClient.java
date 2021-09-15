package com.coderefer.currencyconversionservice.proxy;

import com.coderefer.currencyconversionservice.response.CurrencyConversionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-conversion", url = "http://localhost:8000")
public interface CurrencyConversionFeignClient {
    @GetMapping("//currency-exchange/from/{from}/to/{to}")
    CurrencyConversionResponse getCurrencyExchangeRates(@PathVariable String from,@PathVariable String to);
}
