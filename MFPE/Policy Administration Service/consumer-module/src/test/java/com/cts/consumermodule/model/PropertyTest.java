package com.cts.consumermodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertyTest {

	@Test
	public void propertyTest() {
		Property p=new Property();
		p.setBuildingAge(1L);
		p.setBuildingSqFt("test");
		p.setBuildingStoreys("test");
		p.setBuildingType("test");
		p.setBusinessId(1L);
		p.setConsumerId(1L);
		p.setCostOftheAsset(1L);
		p.setId(1L);
		p.setPropertyValue(1L);
		p.setSalvageValue(1L);
		p.setUsefulLifeofAsset(1L);
		assertEquals(1L,p.getBuildingAge());
		assertEquals(1L,p.getBusinessId());
		assertEquals(1L,p.getConsumerId());
		assertEquals(1L,p.getCostOftheAsset());
		assertEquals(1L,p.getId());
		assertEquals(1L,p.getPropertyValue());
		assertEquals(1L,p.getSalvageValue());
		assertEquals(1L,p.getUsefulLifeofAsset());
		assertEquals("test",p.getBuildingSqFt());
		assertEquals("test",p.getBuildingStoreys());
		assertEquals("test",p.getBuildingType());
	}
	
	@Test
	public void propertyTest1() {
		Property p=new Property(1L,1L,1L,"test","test","test",1L,1L,1L,1L,1L);
		assertEquals(1L,p.getBuildingAge());
		assertEquals(1L,p.getBusinessId());
		assertEquals(1L,p.getConsumerId());
		assertEquals(1L,p.getCostOftheAsset());
		assertEquals(1L,p.getId());
		assertEquals(1L,p.getPropertyValue());
		assertEquals(1L,p.getSalvageValue());
		assertEquals(1L,p.getUsefulLifeofAsset());
		assertEquals("test",p.getBuildingSqFt());
		assertEquals("test",p.getBuildingStoreys());
		assertEquals("test",p.getBuildingType());
	}
	
	@Test
	public void propertyTest2() {
		Property p=new Property(1L,1L,"test","test","test",1L,1L,1L,1L,1L);
		assertEquals(1L,p.getBuildingAge());
		assertEquals(1L,p.getBusinessId());
		assertEquals(1L,p.getConsumerId());
		assertEquals(1L,p.getCostOftheAsset());
		assertEquals(1L,p.getPropertyValue());
		assertEquals(1L,p.getSalvageValue());
		assertEquals(1L,p.getUsefulLifeofAsset());
		assertEquals("test",p.getBuildingSqFt());
		assertEquals("test",p.getBuildingStoreys());
		assertEquals("test",p.getBuildingType());
	}
		
}
