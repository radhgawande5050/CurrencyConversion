package com.currency.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.beans.CurrencyConversion;
@FeignClient(name="currency-exchange")
//@FeignClient(name="currency-exchange",url="localhost:9393")
public interface CurrencyExchangeClient {
	
	
	@GetMapping(value="/currencyEx/from/{from}/to/{to}")
	public CurrencyConversion retriveExchange(@PathVariable String from,@PathVariable String to);

}
