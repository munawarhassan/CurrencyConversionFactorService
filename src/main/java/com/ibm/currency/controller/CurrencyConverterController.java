package com.ibm.currency.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currency.model.CoreException;
import com.ibm.currency.model.CurrencyConversionFactor;
import com.ibm.currency.service.CurrencyConverterService;

@RestController
@RequestMapping("/currencyconversionfactor")
public class CurrencyConverterController{
	
	@Autowired
	private CurrencyConverterService currencyservice;
	@RequestMapping(path = "/default", method = RequestMethod.GET)
	public String getDefaultMessage() {
		return "I am Ready for currency converter springboot assignment";
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
	
	@RequestMapping(path = "/getconversionfactor", method = RequestMethod.GET, produces = {"application/json"})	
    public ResponseEntity<?> getConversionFactor(@RequestBody String countryCode) throws CoreException{ 
			
		return currencyservice.getConversionfactor(countryCode);
		
    }
}
