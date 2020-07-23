package com.ibm.currency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name = "currencyconversionfactor")
public class CurrencyConversionFactor extends CoreModel{
	
   
	
	@Column(name = "id", table = "currencyconversionfactor" , unique = true )
	private Integer id;
	@Id
	@Column(name = "currency", table = "currencyconversionfactor",  unique = true)	
	private String currency;	
	@Column(name = "countrycode", table = "currencyconversionfactor" , unique = true )
	private String countryCode;
	@Column(name = "conversionfactor", table = "currencyconversionfactor")
	private Double conversionFactor;	
	
	
	
	public CurrencyConversionFactor() {
		super();
	}
	public CurrencyConversionFactor(Integer id,String currency,String countryCode, Double conversionFactor) {		
		this.id = id;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
		this.currency = currency;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
	

}
