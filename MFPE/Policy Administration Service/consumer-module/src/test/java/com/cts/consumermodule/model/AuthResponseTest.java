package com.cts.consumermodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuthResponseTest {

	@Test
	public void Auth() {
		AuthResponse a=new AuthResponse("1","1",true);
		assertTrue(a.isValid());
		assertEquals("1",a.getId());
		assertEquals("1", a.getName());
	}
	
	@Test
	public void Authres() {
		AuthResponse a=new AuthResponse();
		a.setId("1");
		a.setName("1");
		a.setValid(true);
		assertTrue(a.isValid());
		assertEquals("1",a.getId());
		assertEquals("1", a.getName());
	}

}
