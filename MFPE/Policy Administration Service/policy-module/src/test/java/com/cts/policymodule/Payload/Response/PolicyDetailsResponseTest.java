package com.cts.policymodule.Payload.Response;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class PolicyDetailsResponseTest {
	private PolicyDetailsResponse pdr;

	
	@Test
	public void testAllGettersAndSettersOfPolicyDetailsResponse() {
		pdr = new PolicyDetailsResponse();
		pdr.setConsumerId((long)1);
		pdr.setPolicyId("Policy_ID");
		pdr.setPropertyValue((long)1);
		pdr.setConsumerType("Consumer_Type");
		pdr.setAssuredSum("Assured_Sum");
		pdr.setTenure("Tenure");
		pdr.setBusinessValue((long)1);
		pdr.setPropertyType("test");
		pdr.setBaseLocation("Base_Location");
		pdr.setType("Type");
		pdr.setBusinessId((long)1);
		pdr.setPaymentDetails("PaymentDetails");
		pdr.setAcceptanceStatus("AcceptanceStatus");
		pdr.setPolicyStatus("PolicyStatus");
		pdr.setEffectiveDate("EffectiveDate");
		pdr.setCoveredSum("Covered_Sum");
		pdr.setDuration("Duration");
		pdr.setAcceptedQuote("AcceptedQuote");
		assertEquals((long)1,pdr.getConsumerId());
		assertEquals("Policy_ID",pdr.getPolicyId());
		assertEquals("test",pdr.getPropertyType());
		assertEquals("Consumer_Type",pdr.getConsumerType());
		assertEquals("Assured_Sum",pdr.getAssuredSum());
		assertEquals("Tenure",pdr.getTenure());
		assertEquals((long)1,pdr.getBusinessValue());
		assertEquals((long)1,pdr.getPropertyValue());
		assertEquals("Base_Location",pdr.getBaseLocation());
		assertEquals("Type",pdr.getType());
		assertEquals((long)1,pdr.getBusinessId());
		assertEquals("PaymentDetails",pdr.getPaymentDetails());
		assertEquals("AcceptanceStatus",pdr.getAcceptanceStatus());
		assertEquals("PolicyStatus",pdr.getPolicyStatus());
		assertEquals("EffectiveDate",pdr.getEffectiveDate());
		assertEquals("Covered_Sum",pdr.getCoveredSum());
		assertEquals("Duration",pdr.getDuration());
		assertEquals("AcceptedQuote",pdr.getAcceptedQuote());	
		
	}
	
	@Test
	public void testPolicyDetailsResponseConstructor() {
		pdr = new PolicyDetailsResponse((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test",(long)1,"test","test","test","test","test","test","test");
		assertEquals((long)1,pdr.getConsumerId());
		assertEquals("test",pdr.getPolicyId());
		assertEquals("test",pdr.getPropertyType());
		assertEquals("test",pdr.getConsumerType());
		assertEquals("test",pdr.getAssuredSum());
		assertEquals("test",pdr.getTenure());
		assertEquals((long)1,pdr.getBusinessValue());
		assertEquals((long)1,pdr.getPropertyValue());
		assertEquals("test",pdr.getBaseLocation());
		assertEquals("test",pdr.getType());
		assertEquals((long)1,pdr.getBusinessId());
		assertEquals("test",pdr.getPaymentDetails());
		assertEquals("test",pdr.getAcceptanceStatus());
		assertEquals("test",pdr.getPolicyStatus());
		assertEquals("test",pdr.getEffectiveDate());
		assertEquals("test",pdr.getCoveredSum());
		assertEquals("test",pdr.getDuration());
		assertEquals("test",pdr.getAcceptedQuote());	
		
	}

}
