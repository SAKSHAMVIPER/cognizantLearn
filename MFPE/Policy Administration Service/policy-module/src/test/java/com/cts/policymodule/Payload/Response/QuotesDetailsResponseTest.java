package com.cts.policymodule.Payload.Response;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)

class QuotesDetailsResponseTest {
	private QuoteDetailsResponse qdr;

	@Test
	public void testAllGettersAndSettersOfQuotesDetailsResponse() {
		qdr = new QuoteDetailsResponse();
		qdr.setQuotes("Quotes");
		assertEquals("Quotes",qdr.getQuotes());
	}
	
	@Test
	public void testQuotesDetailsResponseConstructor() {
		qdr = new QuoteDetailsResponse("Quotes");
		assertEquals("Quotes",qdr.getQuotes());
	}
	

}
