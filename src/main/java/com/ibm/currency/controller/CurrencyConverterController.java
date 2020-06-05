package com.ibm.currency.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currency.model.CoreException;
import com.ibm.currency.model.CurrencyConversionFactor;
import com.ibm.currency.model.CurrencyExchangeBean;
import com.ibm.currency.service.CurrencyConverterService;

@RestController
//@RefreshScope
@RequestMapping("/currencyconversionfactor")
public class CurrencyConverterController{
	
	
	@Value("${currencyconversionservice.greetprop}")
	private String greetProp;

	
	@Autowired
	private CurrencyConverterService currencyservice;
	@RequestMapping(path = "/default", method = RequestMethod.GET)
	public String getDefaultMessage() {
		return greetProp;
	}
	
	//@ExceptionHandler(CurrencyConverterException.class)
	//@ResponseStatus(value = HttpStatus.CREATED , reason = "CurrencyConversionFactor Inserted")
	@RequestMapping(path = "/addconversionfactor", method = RequestMethod.POST)	
    public ResponseEntity<?> addConversionFactor(@RequestBody CurrencyConversionFactor ccf){ 
			
		return currencyservice.createConversionfactor(ccf);
		
    }
	
	@RequestMapping(path = "/updateconversionfactor", method = RequestMethod.POST, produces = {"application/json"})	
    public ResponseEntity<?> updateConversionFactor(@RequestBody CurrencyConversionFactor ccf) throws CoreException{ 
			
		return currencyservice.updateConversionfactor(ccf);
		
    }

	
	@RequestMapping(path = "/getconversionfactor", method = RequestMethod.POST, produces = {"application/json"})	
    public CurrencyExchangeBean getConversionFactor(@RequestBody CurrencyExchangeBean currencyExchangeBean) throws CoreException{ 
			   
		return currencyservice.getConversionfactor(currencyExchangeBean.getCountryCode());
		
    }
	
	
}
