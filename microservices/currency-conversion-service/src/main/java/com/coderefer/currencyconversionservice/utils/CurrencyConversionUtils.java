package com.coderefer.currencyconversionservice.utils;

import java.math.BigDecimal;

public class CurrencyConversionUtils {
    public static BigDecimal calculateTotalAmount(BigDecimal conversionMultiple, BigDecimal quantity) {
        return conversionMultiple.multiply(quantity);
    }
}
