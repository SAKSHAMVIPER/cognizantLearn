package com.cts.consumermodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BusinessMasterTest {

	@Test
	public void businessTest(){
		BusinessMaster bm=new BusinessMaster();
		bm.setId(1L);
		bm.setBusinessAge(1L);
		bm.setBusinessType("test");
		bm.setTotalEmployees(1L);
		assertEquals(1L,bm.getId());
		assertEquals(1L,bm.getBusinessAge());
		assertEquals(1L,bm.getTotalEmployees());
		assertEquals("test",bm.getBusinessType());	
	}
	
	@Test
	public void businessTest1() {
		BusinessMaster bm=new BusinessMaster(1L,"test",1L,1L);
		assertEquals(1L,bm.getId());
		assertEquals(1L,bm.getId());
		assertEquals(1L,bm.getTotalEmployees());
		assertEquals("test",bm.getBusinessType());	
	}

}
