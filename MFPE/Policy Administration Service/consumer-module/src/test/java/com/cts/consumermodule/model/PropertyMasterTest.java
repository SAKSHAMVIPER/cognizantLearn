package com.cts.consumermodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertyMasterTest {

	@Test
	public void propertyMasterTest() {
		PropertyMaster p=new PropertyMaster();
		p.setBuildingAge(1L);
		p.setBuildingType("test");
		p.setId(1L);
		assertEquals(1L,p.getBuildingAge());
		assertEquals(1L,p.getId());
		assertEquals("test",p.getBuildingType());
	}
	
	@Test
	public void propertyMasterTest1() {
		PropertyMaster p=new PropertyMaster(1L,"test",1L);
		assertEquals(1L,p.getBuildingAge());
		assertEquals(1L,p.getId());
		assertEquals("test",p.getBuildingType());
	}
}
