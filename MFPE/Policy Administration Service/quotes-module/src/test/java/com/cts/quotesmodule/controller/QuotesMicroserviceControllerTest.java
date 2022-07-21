package com.cts.quotesmodule.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cts.quotesmodule.model.QuotesMaster;
import com.cts.quotesmodule.repository.QuotesRepository;
import com.cts.quotesmodule.service.QuotesMasterService;



@ExtendWith(SpringExtension.class)
@WebMvcTest(value = QuotesController.class)
@AutoConfigureMockMvc
class QuotesMicroserviceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private QuotesRepository quotesMasterRepository;
	
	@MockBean
	private QuotesMasterService quotesMasterService;
	
	@Autowired
	private QuotesController quotesController;
	@Test
	public void getQuotesForPolicy() throws Exception {
		QuotesMaster quotes = new QuotesMaster(11, (long) 1, (long) 1, "type", "quotes");
		Mockito.when(quotesMasterService.getQuoteMaster(Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyString())).thenReturn(quotes);
		Mockito.when(quotesMasterService.isSessionValid(Mockito.anyString())).thenReturn(true);
		Mockito.when(quotesMasterRepository.findByBusinessValueAndPropertyValueAndPropertyType(Mockito.anyLong(),Mockito.anyLong(),Mockito.anyString()))
		.thenReturn(quotes);
		String ans=quotesController.getQuotes("1",1L,1L,"1");
		assertEquals(ans,quotes.getQuote());

	}

	@Test
	public void getQuotesForPolicyError() throws Exception {
//		QuotesMaster quotes = new QuotesMaster(11, (long) 1, (long) 1, "type", "quotes");
		Mockito.when(quotesMasterService.getQuoteMaster(Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyString())).thenThrow(new NullPointerException());
		Mockito.when(quotesMasterService.isSessionValid(Mockito.anyString())).thenReturn(true);
//		Mockito.when(quotesMasterRepository.findByBusinessValueAndPropertyValueAndPropertyType(Mockito.anyLong(),Mockito.anyLong(),Mockito.anyString()))
//		.thenReturn(quotes);
		String ans=quotesController.getQuotes("1",1L,1L,"1");
		assertEquals("No Quotes, Contact Insurance Provider",ans);
	}
	@Test
	public void getQuotesForPolicyInvalid() throws Exception {
//		QuotesMaster quotes = new QuotesMaster(11, (long) 1, (long) 1, "type", "quotes");
		Mockito.when(quotesMasterService.getQuoteMaster(Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyString())).thenThrow(new NullPointerException());
//		Mockito.when(quotesMasterService.isSessionValid(Mockito.anyString())).thenReturn(true);
//		Mockito.when(quotesMasterRepository.findByBusinessValueAndPropertyValueAndPropertyType(Mockito.anyLong(),Mockito.anyLong(),Mockito.anyString()))
//		.thenReturn(quotes);
		String ans=quotesController.getQuotes("1",1L,1L,"1");
		assertEquals("Invalid Authorization",ans);
	}

}
