package com.ibm.currency.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
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
import com.ibm.currency.model.CurrencyConverterConfig;
import com.ibm.currency.service.CurrencyConverterService;

@RestController
//@RefreshScope
@RequestMapping("/currencyconversionfactor")
public class CurrencyConverterController{
	private static Logger log = LoggerFactory.getLogger(CurrencyConverterController.class);
	
	@Value("${currencyconversionservice.greetprop}")
	private String greetProp;

	@Autowired
	private CurrencyConverterConfig  currencyConverterConfig;
	
	@Autowired
	private CurrencyConverterService currencyservice;
	@RequestMapping(path = "/default", method = RequestMethod.GET)
	public String getDefaultMessage() {
		
		log.info("greetProp value ="+ greetProp);
		
		return currencyConverterConfig.getGreetProp();
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

	
	@RequestMapping(path = "/getconversionfactor/{currency}", method = RequestMethod.GET, produces = {"application/json"})	
    public CurrencyConversionFactor getConversionFactor(@PathVariable String currency) throws CoreException{ 
		
	
		CurrencyConversionFactor ccf = currencyservice.getConversionfactor(currency);
		if(null !=ccf) {
			return ccf;
		}else {
			throw new CoreException(400,"No Data Found");
		}
		
    }
	
	
}
