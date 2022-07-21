package com.cts.policymodule.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class PolicyMasterTest {


	private PolicyMaster pm;

	
	 	@Test
	    public void testAllGettersAndSettersOfPolicyMaster() {
		 pm = new PolicyMaster();
	        pm.setID((long)100);
	        pm.setPolicyId("P01");
	        pm.setPropertyType("property_type");
	        pm.setAssuredSum("10,000");
	        pm.setBaseLocation("CHD");
	        pm.setBusinessValue(1L);
	        pm.setConsumerType("consumer_type");
	        pm.setPropertyType("property_type");
	        pm.setTenure("tenure");
	        pm.setType("type");
	        pm.setPropertyValue((long)10000);
	        assertEquals(100,pm.getID());
	        assertEquals("P01",pm.getPolicyId());
	        assertEquals("property_type",pm.getPropertyType());
	        assertEquals("10,000",pm.getAssuredSum());
	        assertEquals("CHD",pm.getBaseLocation());
	        assertEquals(1L,pm.getBusinessValue());
	        assertEquals("consumer_type",pm.getConsumerType());
	        assertEquals("property_type",pm.getPropertyType());
	        assertEquals("tenure",pm.getTenure());
	        assertEquals("type",pm.getType());
	        assertEquals(10000L,pm.getPropertyValue());
	    }
	 	
	 	@Test
	    public void testPolicyMasterConstructor() {
		 pm = new PolicyMaster((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test");
	        assertEquals((long)1,pm.getID());
	        assertEquals("test",pm.getPolicyId());
	        assertEquals("test",pm.getPropertyType());
	        assertEquals("test",pm.getAssuredSum());
	        assertEquals("test",pm.getBaseLocation());
	        assertEquals((long)1,pm.getBusinessValue());
	        assertEquals("test",pm.getConsumerType());
	        assertEquals((long)1,pm.getPropertyValue());
	        assertEquals("test",pm.getTenure());
	        assertEquals("test",pm.getType());
	    }

}