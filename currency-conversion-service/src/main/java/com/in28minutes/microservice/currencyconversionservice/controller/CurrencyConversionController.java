package com.in28minutes.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservice.currencyconversionservice.beans.CurrencyConversion;
import com.in28minutes.microservice.currencyconversionservice.services.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionService currencyConversionService;  
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable String quantity) {

		CurrencyConversion currencyConversion = currencyConversionService.retrieveCurrencyExchange(from, to);
		
		CurrencyConversion currencyConversion2 = new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(), new BigDecimal(quantity));
		currencyConversion2.setTotalCalculatedAmount(currencyConversion2.getQuantity().multiply(currencyConversion.getConversionMultiple()));
		currencyConversion2.setEnvironment(currencyConversion.getEnvironment());
		
		return currencyConversion2;
	}
}
