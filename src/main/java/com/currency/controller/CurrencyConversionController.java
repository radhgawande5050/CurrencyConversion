package com.currency.controller;

import com.currency.beans.CurrencyConversion;
import com.currency.client.CurrencyExchangeClient;

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
	CurrencyExchangeClient client;
	
	// By using RestTemplate

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateTotalConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
       
    	HashMap<String, String> uriVairable = new HashMap<>();

        uriVairable.put("from", from);
        uriVairable.put("to", to);

        ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity("http://localhost:9393/currencyEx/from/USD/to/INR", CurrencyConversion.class, uriVairable);
        CurrencyConversion conversion = forEntity.getBody();

        CurrencyConversion totalconversion=new CurrencyConversion(conversion.getId(),
        		from, 
        		to, 
        		quantity,
        		conversion.getConversionMultiple(),
        		quantity.multiply(conversion.getConversionMultiple()),
        		conversion.getEnv());

        return totalconversion;
    }
    
	//By using feign client
	 
    @GetMapping("/Currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}") 
    public
	 CurrencyConversion calculateTotalConversionfeign(@PathVariable String
	 from,@PathVariable String to,@PathVariable BigDecimal quantity) {
	 
	  CurrencyConversion conversion = client.retriveExchange(from, to);
	  
	  CurrencyConversion totalconversion=new CurrencyConversion(conversion.getId(),
	  from, to, quantity, conversion.getConversionMultiple(),
	  quantity.multiply(conversion.getConversionMultiple()), conversion.getEnv());
	   return totalconversion;
	 
	  }
	 
}
