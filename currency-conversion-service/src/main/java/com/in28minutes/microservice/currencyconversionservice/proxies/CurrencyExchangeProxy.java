package com.in28minutes.microservice.currencyconversionservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microservice.currencyconversionservice.beans.CurrencyConversion;

//name is microservice application name
//@FeignClient(name="currency-exchange", url="http://localhost:8000")
//if load balancing does not happen then wait for 30 to 60 seconds and then verify it.
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}")
	CurrencyConversion retrieveCurrencyExchangeFeign(@PathVariable String from, @PathVariable String to);
	

}
