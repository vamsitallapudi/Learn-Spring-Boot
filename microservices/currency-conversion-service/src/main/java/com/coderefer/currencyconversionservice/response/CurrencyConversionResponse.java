package com.coderefer.currencyconversionservice.response;


import lombok.Data;

import java.math.BigDecimal;
@Data
public class CurrencyConversionResponse {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
