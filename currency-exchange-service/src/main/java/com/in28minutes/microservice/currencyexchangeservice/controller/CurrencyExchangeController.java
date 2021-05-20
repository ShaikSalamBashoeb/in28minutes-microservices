package com.in28minutes.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservice.currencyexchangeservice.bean.CurrencyExchange;


@RestController
public class CurrencyExchangeController {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyExchange retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		
		return new CurrencyExchange(1L, from, to, new BigDecimal(65.0));
		
	}

}
