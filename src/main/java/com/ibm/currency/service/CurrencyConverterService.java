package com.ibm.currency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.currency.model.CoreException;
import com.ibm.currency.model.CoreModel;
import com.ibm.currency.model.CoreResponseModel;
import com.ibm.currency.model.CurrencyConversionFactor;
import com.ibm.currency.repo.CurrencyConverterRepository;

@Service
public class CurrencyConverterService{
	
	@Autowired
	private CurrencyConverterRepository  currencyRepo;
	
	@Autowired
	private CoreResponseModel respModel;

	
	private ResponseEntity<?>  respEntity;
	
	public ResponseEntity<?>  createConversionfactor(CurrencyConversionFactor ccf){
		try {
			CurrencyConversionFactor obj = currencyRepo.save(ccf);
			return populateSuccessResponseWithResult(obj, "Successfully saved records to database");
		} catch (Exception ex) {
		
			return populateFailureResponse("Failed to insert record"+ ex.getMessage());
		}
	}
	
	public ResponseEntity<?>  updateConversionfactor(CurrencyConversionFactor ccf){
		try {			
			CurrencyConversionFactor  currencyconversionfactor = currencyRepo.findByCountryCode(ccf.getCountryCode());
			if(null == currencyconversionfactor) {
				return populateFailureResponse("There is no such country code");
			}
			currencyconversionfactor.setConversionFactor(ccf.getConversionFactor());
			CurrencyConversionFactor obj = currencyRepo.save(ccf);
			return populateSuccessResponseWithResult(obj, "Successfully Update records to database");
		} catch (Exception ex) {
		
			return populateFailureResponse("Failed to update record"+ ex.getMessage());
		}
	}
	
	public ResponseEntity<?>  getConversionfactor(String countryCode){
		try {			
			CurrencyConversionFactor  currencyconversionfactor = currencyRepo.findByCountryCode(countryCode);			
			return populateSuccessResponseWithResult(currencyconversionfactor, "Successfully fetch record");
		} catch (Exception ex) {
		
			return populateFailureResponse("Faiiled to find record"+ ex.getMessage());
		}
	}
	
	
	
public ResponseEntity<?>   populateSuccessResponseWithResult(CurrencyConversionFactor result, String message){
		
		respModel = new CoreResponseModel();
		respModel.setStatusCode(200);
		respModel.setMessage(message);
		respModel.setResponseBody(result);
		respEntity = new ResponseEntity<Object>(respModel,HttpStatus.OK);		
		return respEntity;
	}

public ResponseEntity<?>  populateFailureResponse( String message){	
	respModel = new CoreResponseModel();
	respModel.setStatusCode(HttpStatus.BAD_REQUEST.value());
	respModel.setSuccess(false);
	respModel.setMessage(message);		
	respEntity = new ResponseEntity<Object>(respModel,HttpStatus.BAD_REQUEST);		
	return respEntity;
}

}
