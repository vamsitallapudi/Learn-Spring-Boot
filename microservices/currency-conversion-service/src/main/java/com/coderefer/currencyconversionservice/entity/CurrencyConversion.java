package com.coderefer.currencyconversionservice.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CurrencyConversion {
    @NonNull
    private Long id;
    @NonNull
    private String from;
    @NonNull
    private String to;
    @NonNull
    private BigDecimal quantity;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculatedAmount;
    private String env;
}
