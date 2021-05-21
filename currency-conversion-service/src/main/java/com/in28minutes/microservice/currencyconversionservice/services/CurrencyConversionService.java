package com.in28minutes.microservice.currencyconversionservice.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microservice.currencyconversionservice.beans.CurrencyConversion;
import com.in28minutes.microservice.currencyconversionservice.proxies.CurrencyExchangeProxy;

@Service
public class CurrencyConversionService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	public CurrencyConversion retrieveCurrencyExchange(String from, String to) {
		
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> currencyConversionResponse = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/USA/to/INR", CurrencyConversion.class, 
				uriVariables);
		
		return currencyConversionResponse.getBody();
		
		/*
		 * HeadersBuilder<String> accept =
		 * RequestEntity.get("http://localhost:8000/currency-exchange/from/USA/to/INR")
		 * .accept(MediaType.APPLICATION_JSON); restTemplate.exchange(accept,
		 * CurrencyExchange.class);
		 */
	}
	
public CurrencyConversion retrieveCurrencyExchangeFeign(String from, String to) {
		
		CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveCurrencyExchangeFeign(from, to);
		
		return currencyConversion;
		
	}

}
