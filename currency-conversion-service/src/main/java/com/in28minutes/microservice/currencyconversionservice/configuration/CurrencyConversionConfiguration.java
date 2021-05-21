package com.in28minutes.microservice.currencyconversionservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CurrencyConversionConfiguration {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
