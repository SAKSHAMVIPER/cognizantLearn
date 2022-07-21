package com.cts.consumermodule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConsumerServiceTests {
	
	@InjectMocks
	private ConsumerService consumerService;
	
	@Test
	public void testCalculatePropertyValue() {
		long result = consumerService.calculatePropertyValue((long)200,(long)20,(long)13);
		assertEquals((long)9,result);
	}

}
