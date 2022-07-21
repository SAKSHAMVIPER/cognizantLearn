package com.cts.quotesmodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModelTest {
	
	private QuotesMaster qm; 
	@Test
	public void Quotemaster() {
		qm=new QuotesMaster(1,1L,1L,"1","1");
		assertEquals(1,qm.getId());
		assertEquals(1L,qm.getBusinessValue());
		assertEquals(1L,qm.getPropertyValue());
		assertEquals("1",qm.getPropertyType());
		assertEquals("1",qm.getQuote());
	}
	
	@Test
	public void quote() {
		qm=new QuotesMaster();
		qm.setId(1);
		qm.setBusinessValue(1L);
		qm.setPropertyType("1");
		qm.setQuote("1");
		qm.setPropertyValue(1L);
		assertEquals(1,qm.getId());
		assertEquals(1L,qm.getBusinessValue());
		assertEquals(1L,qm.getPropertyValue());
		assertEquals("1",qm.getPropertyType());
		assertEquals("1",qm.getQuote());
	}

}
