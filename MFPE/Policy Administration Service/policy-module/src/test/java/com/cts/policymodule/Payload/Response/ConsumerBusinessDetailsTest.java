package com.cts.policymodule.Payload.Response;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)

class ConsumerBusinessDetailsTest {
	private ConsumerBusinessDetails cbd;


	@Test
	public void testAllGettersAndSettersOfConsumerBusinessDetails() {
		cbd = new ConsumerBusinessDetails();
		cbd.setFirstName("First_Name");
		cbd.setLastName("Last_Name");
		cbd.setDob("DOB");
		cbd.setBusinessName("Business_Name");
		cbd.setPan("PANDetails");
		cbd.setEmail("EMAIL");
		cbd.setValidity("Validity");
		cbd.setAgentName("AgentName");
		cbd.setAgentId((long)1);
		cbd.setBusinessId((long)1);
		cbd.setConsumerId((long)1);
		cbd.setBusinessType("Business_Type");
		cbd.setBusinessTurnover((long)1);
		cbd.setCapitalInvested((long)1);
		cbd.setTotalEmployees("1");
		cbd.setBusinessAge((long)1);
		assertEquals("First_Name",cbd.getFirstName());
		assertEquals("Last_Name",cbd.getLastName());
		assertEquals("DOB",cbd.getDob());
		assertEquals("Business_Name",cbd.getBusinessName());
		assertEquals("PANDetails",cbd.getPan());
		assertEquals("EMAIL",cbd.getEmail());
		assertEquals("Validity",cbd.getValidity());
		assertEquals("AgentName",cbd.getAgentName());
		assertEquals((long)1,cbd.getAgentId());
		assertEquals((long)1,cbd.getBusinessId());
		assertEquals((long)1,cbd.getConsumerId());
		assertEquals("Business_Type",cbd.getBusinessType());
		assertEquals((long)1,cbd.getBusinessTurnover());
		assertEquals((long)1,cbd.getCapitalInvested());
		assertEquals("1",cbd.getTotalEmployees());
		assertEquals((long)1,cbd.getBusinessAge());
	
	}
	
	@Test
	public void testConsumerBusinessDetailsConstructor() {
		cbd = new ConsumerBusinessDetails((long)1,(long)1,"test","test","test","test","test","test","test",(long)1,"test",(long)1,"test",(long)1,(long)1,"test");
		assertEquals("test",cbd.getFirstName());
		assertEquals("test",cbd.getLastName());
		assertEquals("test",cbd.getDob());
		assertEquals("test",cbd.getBusinessName());
		assertEquals("test",cbd.getPan());
		assertEquals("test",cbd.getEmail());
		assertEquals("test",cbd.getValidity());
		assertEquals("test",cbd.getAgentName());
		assertEquals((long)1,cbd.getAgentId());
		assertEquals((long)1,cbd.getBusinessId());
		assertEquals((long)1,cbd.getConsumerId());
		assertEquals("test",cbd.getBusinessType());
		assertEquals((long)1,cbd.getBusinessTurnover());
		assertEquals((long)1,cbd.getCapitalInvested());
		assertEquals("test",cbd.getTotalEmployees());
		assertEquals((long)1,cbd.getBusinessAge());
	
	}

}
