package com.cts.policymodule.Payload.Response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)

class MessageResponseTest {
	private MessageResponse mr;
	@BeforeEach()
	 public void setUp() {
		mr = new MessageResponse("message");
	}

	@Test
	public void testAllGettersAndSettersOfMessageResponse() {
		assertEquals("message",mr.getMessage());
	}

}
