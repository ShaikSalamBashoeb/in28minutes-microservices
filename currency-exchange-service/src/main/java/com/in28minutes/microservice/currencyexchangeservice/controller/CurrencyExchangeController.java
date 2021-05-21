package com.in28minutes.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservice.currencyexchangeservice.bean.CurrencyExchange;
import com.in28minutes.microservice.currencyexchangeservice.services.CurrencyExchangeService;


@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyExchange retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		
		CurrencyExchange currencyExchange = currencyExchangeService.getCurrencyExchange(from, to);
//		new CurrencyExchange(1L, from, to, new BigDecimal(65.0));
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
		
	}

}
