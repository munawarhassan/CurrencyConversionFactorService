package com.ibm.currency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name = "currencyconversionfactor")
public class CurrencyConversionFactor extends CoreModel{
	
   
     
	@Id
	@Column(name = "countrycode", table = "currencyconversionfactor" , unique = true )
	private String countryCode;
	@Column(name = "conversionfactor", table = "currencyconversionfactor")
	private Double conversionFactor;
	
	
	
	public CurrencyConversionFactor() {
		super();
	}
	public CurrencyConversionFactor(String countryCode, Double conversionFactor) {		
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}
	
	
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public Double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
	
	
	

}
