package com.in28minutes.microservices.limitsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@org.springframework.context.annotation.Configuration
@ConfigurationProperties("limits-service")
public class Configuration {

	private int minimum;
	private int maximum;

	public Configuration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
}
