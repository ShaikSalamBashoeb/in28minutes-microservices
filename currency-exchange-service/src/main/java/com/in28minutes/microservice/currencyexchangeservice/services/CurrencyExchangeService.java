package com.in28minutes.microservice.currencyexchangeservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.microservice.currencyexchangeservice.bean.CurrencyExchange;
import com.in28minutes.microservice.currencyexchangeservice.repositories.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	public CurrencyExchange getCurrencyExchange(String from, String to) {
		
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}

}
