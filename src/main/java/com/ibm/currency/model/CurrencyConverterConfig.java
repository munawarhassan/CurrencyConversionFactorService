package com.ibm.currency.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@Configuration
@ConfigurationProperties
public class CurrencyConverterConfig {	
	
	private String greetProp;
	
	public String getGreetProp() {
		return greetProp;
	}
	public void setGreetProp(String greetProp) {
		this.greetProp = greetProp;
	}
	
   
}
