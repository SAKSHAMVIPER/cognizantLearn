package com.cts.consumermodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusinessTest {

	@Test
	public void businessTest() {
		Business b=new Business();
		b.setId(1L);
		b.setBusinessAge(1L);
		b.setBusinessName("test");
		b.setBusinessTurnover(1L);
		b.setBusinessType("test");
		b.setCapitalInvested(1L);
		b.setConsumerId(1L);
		b.setTotalEmployees(1L);
		assertEquals(1L,b.getBusinessAge());
		assertEquals(1L,b.getId());
		assertEquals(1L,b.getBusinessTurnover());
		assertEquals(1L,b.getCapitalInvested());
		assertEquals(1L,b.getConsumerId());
		assertEquals("test",b.getBusinessName());
		assertEquals("test",b.getBusinessType());
	}
	
	@Test
	public void businessTest1() {
		Business b=new Business(1L,1L,"test","test",1L,1L,1L,1L);
		assertEquals(1L,b.getBusinessAge());
		assertEquals(1L,b.getId());
		assertEquals(1L,b.getBusinessTurnover());
		assertEquals(1L,b.getCapitalInvested());
		assertEquals(1L,b.getConsumerId());
		assertEquals("test",b.getBusinessName());
		assertEquals("test",b.getBusinessType());
		assertEquals(1L,b.getTotalEmployees());
	}
	
	@Test
	public void businessTest2() {
		Business b=new Business(1L,"test","test",1L,1L,1L,1L);
		assertEquals(1L,b.getBusinessAge());
		assertEquals(1L,b.getTotalEmployees());
		assertEquals(1L,b.getBusinessTurnover());
		assertEquals(1L,b.getCapitalInvested());
		assertEquals(1L,b.getConsumerId());
		assertEquals("test",b.getBusinessName());
		assertEquals("test",b.getBusinessType());
	}

}
