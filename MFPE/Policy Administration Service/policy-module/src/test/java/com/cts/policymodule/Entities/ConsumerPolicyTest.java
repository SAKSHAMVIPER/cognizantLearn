package com.cts.policymodule.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ConsumerPolicyTest {

	
	private ConsumerPolicy consumerPolicy;
	
	
	@Test
    public void testConsumerPolicy() throws Exception {
		consumerPolicy= new ConsumerPolicy();
		consumerPolicy.setAcceptanceStatus("acceptancestatus");
		consumerPolicy.setAcceptedQuote("acceptedquote");
		consumerPolicy.setBusinessId((long)1);
		consumerPolicy.setConsumerId((long)1);
		consumerPolicy.setCoveredSum("covered_sum");
		consumerPolicy.setDuration("duration");
		consumerPolicy.setEffectiveDate("effectivedate");
		consumerPolicy.setId((long)1);
		consumerPolicy.setPaymentDetails("paymentdetails");
		consumerPolicy.setPolicyId("policyid");
		consumerPolicy.setPolicyStatus("policystatus");
		assertEquals("acceptancestatus",consumerPolicy.getAcceptanceStatus());
		assertEquals("acceptedquote",consumerPolicy.getAcceptedQuote());
		assertEquals((long)1,consumerPolicy.getBusinessId());
		assertEquals((long)1,consumerPolicy.getConsumerId());
		assertEquals("covered_sum",consumerPolicy.getCoveredSum());
		assertEquals("duration",consumerPolicy.getDuration());
		assertEquals("effectivedate",consumerPolicy.getEffectiveDate());
		assertEquals((long)1,consumerPolicy.getId());
		assertEquals("paymentdetails",consumerPolicy.getPaymentDetails());
		assertEquals("policyid",consumerPolicy.getPolicyId());
		assertEquals("policystatus",consumerPolicy.getPolicyStatus());	
	}
	
	@Test
    public void testConsumerPolicyAllConstructor() throws Exception {
		consumerPolicy= new ConsumerPolicy((long)1,"test",(long)1,(long)1,"test","test","test","test",(long)1,(long)1,"test","test","test","test","test","test","test","test","test");
		assertEquals("test",consumerPolicy.getAcceptanceStatus());
		assertEquals("test",consumerPolicy.getAcceptedQuote());
		assertEquals((long)1,consumerPolicy.getBusinessId());
		assertEquals((long)1,consumerPolicy.getConsumerId());
		assertEquals("test",consumerPolicy.getCoveredSum());
		assertEquals("test",consumerPolicy.getDuration());
		assertEquals("test",consumerPolicy.getEffectiveDate());
		assertEquals((long)1,consumerPolicy.getId());
		assertEquals("test",consumerPolicy.getPaymentDetails());
		assertEquals("test",consumerPolicy.getPolicyId());
		assertEquals("test",consumerPolicy.getPolicyStatus());	
		assertEquals("test",consumerPolicy.getPropertyType());
		assertEquals("test",consumerPolicy.getConsumerType());
		assertEquals("test",consumerPolicy.getAssuredSum());
		assertEquals("test",consumerPolicy.getTenure());
		assertEquals((long)1,consumerPolicy.getBusinessValue());
		assertEquals((long)1,consumerPolicy.getPropertyValue());
		assertEquals("test",consumerPolicy.getBaseLocation());
		assertEquals("test",consumerPolicy.getType());
	}

	
	@Test
    public void testConsumerPolicyConstructor() throws Exception {
		consumerPolicy= new ConsumerPolicy((long)1,(long)1,"test","test");
		assertEquals("test",consumerPolicy.getAcceptedQuote());
		assertEquals((long)1,consumerPolicy.getBusinessId());
		assertEquals((long)1,consumerPolicy.getConsumerId());
		assertEquals("test",consumerPolicy.getPolicyStatus());	
	}

}