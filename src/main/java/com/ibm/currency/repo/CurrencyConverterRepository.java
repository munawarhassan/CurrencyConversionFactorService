package com.ibm.currency.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.currency.model.CurrencyConversionFactor;

@Repository
public interface CurrencyConverterRepository extends JpaRepository<CurrencyConversionFactor, Integer>{
		
	
	CurrencyConversionFactor findByCountryCode(String countryCode);
}
