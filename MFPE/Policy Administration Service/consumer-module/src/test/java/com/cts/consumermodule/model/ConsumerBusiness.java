package com.cts.consumermodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerTest {

	@Test
	public void consumerTest() {
		Consumer consumer=new Consumer();
		consumer.setAgentId(1L);
		consumer.setAgentName("test");
		consumer.setBusinessName("test");
		consumer.setDob("test");
		consumer.setEmail("test");
		consumer.setFirstName("test");
		consumer.setId(1L);
		consumer.setLastName("test");
		consumer.setPan("test");
		consumer.setValidity("test");
		assertEquals(1L,consumer.getAgentId());
		assertEquals(1L,consumer.getId());
		assertEquals("test",consumer.getAgentName());
		assertEquals("test",consumer.getBusinessName());
		assertEquals("test",consumer.getDob());
		assertEquals("test",consumer.getEmail());
		assertEquals("test",consumer.getFirstName());
		assertEquals("test",consumer.getLastName());
		assertEquals("test",consumer.getPan());
		assertEquals("test",consumer.getValidity());
	}
	
	@Test
	public void consumerTest1() {
		Consumer consumer=new Consumer(1L,"test","test","test","test","test","test","test","test",1L);
		assertEquals(1L,consumer.getAgentId());
		assertEquals(1L,consumer.getId());
		assertEquals("test",consumer.getAgentName());
		assertEquals("test",consumer.getBusinessName());
		assertEquals("test",consumer.getDob());
		assertEquals("test",consumer.getEmail());
		assertEquals("test",consumer.getFirstName());
		assertEquals("test",consumer.getLastName());
		assertEquals("test",consumer.getPan());
		assertEquals("test",consumer.getValidity());
	}
	
	@Test
	public void consumerTest2() {
		Consumer consumer=new Consumer("test","test","test","test","test","test","test","test",1L);
		assertEquals(1L,consumer.getAgentId());
		assertEquals("test",consumer.getAgentName());
		assertEquals("test",consumer.getBusinessName());
		assertEquals("test",consumer.getDob());
		assertEquals("test",consumer.getEmail());
		assertEquals("test",consumer.getFirstName());
		assertEquals("test",consumer.getLastName());
		assertEquals("test",consumer.getPan());
		assertEquals("test",consumer.getValidity());
	}

}
