package com.cts.quotesmodule.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.quotesmodule.model.QuotesMaster;
import com.cts.quotesmodule.repository.QuotesRepository;

class ServiceTest {

	@MockBean
	QuotesRepository quotesRepository;
	
	@Autowired
	QuotesMasterService qms;
	
//	@Test
//	public void getQute() {
//		QuotesMaster qm=new QuotesMaster(1,1L,1L,"1","1");
//		Mockito.when(quotesRepository.findByBusinessValueAndPropertyValueAndPropertyType(
//				Mockito.anyLong(),Mockito.anyLong(),Mockito.anyString())).thenReturn(qm);
//		QuotesMaster q=qms.getQuoteMaster(1L, 1L, "1");
//		assertEquals(1,q.getId());
//	}

}
