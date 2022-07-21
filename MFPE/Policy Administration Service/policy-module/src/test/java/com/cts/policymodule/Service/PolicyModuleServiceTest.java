package com.cts.policymodule.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.policymodule.Entities.ConsumerPolicy;
import com.cts.policymodule.Entities.PolicyMaster;
import com.cts.policymodule.Exception.ConsumerPolicyNotFoundException;
import com.cts.policymodule.Exception.PolicyNotFoundException;
import com.cts.policymodule.Payload.Request.CreatePolicyRequest;
import com.cts.policymodule.Payload.Request.IssuePolicyRequest;
import com.cts.policymodule.Payload.Response.AuthResponse;
import com.cts.policymodule.Payload.Response.ConsumerBusinessDetails;
import com.cts.policymodule.Payload.Response.MessageResponse;
import com.cts.policymodule.Payload.Response.PolicyDetailsResponse;
import com.cts.policymodule.Payload.Response.QuoteDetailsResponse;
import com.cts.policymodule.Repository.ConsumerPolicyRepository;
import com.cts.policymodule.Repository.PolicyMasterRepository;
import com.cts.policymodule.RestClients.AuthClient;
import com.cts.policymodule.RestClients.ConsumerClient;
import com.cts.policymodule.RestClients.QuotesClient;

@SpringBootTest
class PolicyModuleServiceTest {

	private static String AuthToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAiLCJleHAiOjE2NTY4NjMwMDIsImlhdCI6MTY1Njg2MjEwMn0.dbmctJujEQ5Ic5uu1lWzfRIHL92D3o0Q6zTYzglrJwc";

	@MockBean
    private ConsumerPolicyRepository consumerPolicyRepository;

	@MockBean
    private PolicyMasterRepository policyMasterRepository;

	@MockBean
    private ConsumerClient consumerClient;

	@MockBean
    private QuotesClient quotesClient;
    
	@MockBean
	private AuthClient authClient;
	
	@Autowired
	private PolicyService policyService; 
	
//	@Test
//	public void createPolicyTest() throws Exception{
//		ConsumerBusinessDetails consumerBusinessDetails=new ConsumerBusinessDetails((long)1,(long)1,"hello","hello","hello","hello","hello","hello","hello",1L,"hello",1L,"hello",1L,1L,"hello");
//		ConsumerPolicy cs=new ConsumerPolicy();
//		cs.setId(1L);
//		Mockito.when(consumerClient.viewConsumerBusiness(Mockito.anyString(),Mockito.anyLong())).thenReturn(consumerBusinessDetails);
//		Mockito.when(consumerPolicyRepository.save(Mockito.mock(ConsumerPolicy.class))).thenReturn(cs);
//		MessageResponse msg = policyService.createPolicy(AuthToken,new CreatePolicyRequest((long)1,"hello"));
//        assertEquals("Policy Has been Created with Policy Consumer Id : " + 1 + " .Thank You Very Much!!",msg.getMessage());
//	}
	@Test
	public void getQuotesSuccess() {
		QuoteDetailsResponse q=new QuoteDetailsResponse("quote");
		Mockito.when(quotesClient.quotesResponse(Mockito.anyString(),Mockito.anyLong(),Mockito.anyLong(), Mockito.anyString())).thenReturn("quote");
		QuoteDetailsResponse qdr=policyService.getQuotes(AuthToken, 1L, 2L, "Equipment");
		assertEquals(q.getQuotes(),qdr.getQuotes());
	}
	
	@Test
	public void viewPolicySuccess() throws PolicyNotFoundException, ConsumerPolicyNotFoundException {
		PolicyDetailsResponse pdr = new PolicyDetailsResponse((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test",(long)1,"test","test","test","test","test","test","test");
		PolicyMaster pm = new PolicyMaster((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test");
		ConsumerPolicy cp= new ConsumerPolicy((long)1,"test",(long)1,(long)1,"test","test","test","test",(long)1,(long)1,"test","test","test","test","test","test","test","test","test");
		Mockito.when(policyMasterRepository.findByPolicyId(Mockito.anyString())).thenReturn(pm);
		Mockito.when(consumerPolicyRepository.findByConsumerId(Mockito.anyLong())).thenReturn(cp);
		PolicyDetailsResponse policyDetailsResponse = policyService.viewPolicy(1L, "test");
		assertEquals(pdr.getAcceptanceStatus(),policyDetailsResponse.getAcceptanceStatus());
	}
	
	@Test
	public void issuePolicySuccess() throws ConsumerPolicyNotFoundException, PolicyNotFoundException {
        MessageResponse mr=new MessageResponse();
        mr.setMessage("Policy has been issued to Policy Consumer Id : 1 .Thank You Very Much!!");
		PolicyMaster pm = new PolicyMaster((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test");
        ConsumerPolicy cp= new ConsumerPolicy((long)1,"test",(long)1,(long)1,"test","test","test","test",(long)1,(long)1,"test","test","test","test","test","test","test","test","test");
		IssuePolicyRequest ipr = new IssuePolicyRequest("test",(long)1,(long)1,"test","test");
        Mockito.when(consumerPolicyRepository.findByConsumerIdAndBusinessId(Mockito.anyLong(),Mockito.anyLong())).thenReturn(cp);
        Mockito.when(consumerPolicyRepository.save(cp)).thenReturn(cp);
        Mockito.when(policyMasterRepository.findByPolicyId(Mockito.anyString())).thenReturn(pm);
        MessageResponse msg=policyService.issuePolicy(ipr);
        assertEquals(mr.getMessage(),msg.getMessage());
	}
	public void authTestPass() {
		AuthResponse au=new AuthResponse("1","1",true);
		Mockito.when(authClient.getValidity(Mockito.anyString())).thenReturn(au);
		assertTrue(policyService.isSessionValid("abcdef"));
	}
	public void authTestFail() {
		Mockito.when(authClient.getValidity(Mockito.anyString())).thenThrow(new Exception());
		assertFalse(policyService.isSessionValid("abcdef"));
	}
	
}
