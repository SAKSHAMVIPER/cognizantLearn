package com.cts.policymodule.Payload.Request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class IssuePolicyRequestTest {
	private IssuePolicyRequest ipr;

	@Test
	 public void testAllGettersAndSettersOfIssuePolicyRequest() {
		ipr = new IssuePolicyRequest();
		ipr.setPolicyId("Policy_ID");
		ipr.setConsumerId((long)1);
		ipr.setBusinessId((long)1);
		ipr.setPaymentDetails("Payment_Details");
		ipr.setAcceptanceStatus("Acceptance_Status");
		assertEquals("Policy_ID",ipr.getPolicyId());
		assertEquals((long)1,ipr.getConsumerId());
		assertEquals((long)1,ipr.getBusinessId());
		assertEquals("Payment_Details",ipr.getPaymentDetails());
		assertEquals("Acceptance_Status",ipr.getAcceptanceStatus());
	}
	
	@Test
	 public void testIssuePolicyRequestConstructor() {
		ipr = new IssuePolicyRequest("test",(long)1,(long)1,"test","test");
		assertEquals("test",ipr.getPolicyId());
		assertEquals((long)1,ipr.getConsumerId());
		assertEquals((long)1,ipr.getBusinessId());
		assertEquals("test",ipr.getPaymentDetails());
		assertEquals("test",ipr.getAcceptanceStatus());
	}
}

