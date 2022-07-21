package com.cts.quotesmodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.quotesmodule.client.AuthClient;
import com.cts.quotesmodule.model.AuthResponse;
import com.cts.quotesmodule.model.QuotesMaster;
import com.cts.quotesmodule.repository.QuotesRepository;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuotesMasterService {
	
	@Autowired
	private QuotesRepository quotesRepository;
	
	@Autowired
	AuthClient authClient;
	
	public boolean isSessionValid(String token) {
		try {
			@SuppressWarnings("unused")
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		} 
		return true;	
	}
	
	public QuotesMaster getQuoteMaster(Long businessValue, Long propertyValue, String propertyType) {
		log.info("start service");
		log.info("end service");
		return quotesRepository.findByBusinessValueAndPropertyValueAndPropertyType(businessValue, propertyValue,
				propertyType);
	}

	public List<QuotesMaster> getAllQuotes() {
		return quotesRepository.findAll();
	}

}
