package com.currency.beans;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyConversion {

    private Long id;

    private String from;
    
    private String to;
    
    private BigDecimal quantity;

    private BigDecimal conversionMultiple;

    private BigDecimal totalconnversionMultiple;

    private String env;
}
