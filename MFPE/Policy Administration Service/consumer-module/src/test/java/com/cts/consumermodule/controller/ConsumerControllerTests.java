package com.cts.consumermodule.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.consumermodule.client.AuthClient;
import com.cts.consumermodule.model.Business;
import com.cts.consumermodule.model.Property;
import com.cts.consumermodule.repository.BusinessRepository;
import com.cts.consumermodule.repository.ConsumerRepository;
import com.cts.consumermodule.repository.PropertyRepository;
import com.cts.consumermodule.request.BusinessInputRequest;
import com.cts.consumermodule.request.BusinessUpdateRequest;
import com.cts.consumermodule.request.ConsumerBusinessRequest;
import com.cts.consumermodule.request.UpdateRequest;
import com.cts.consumermodule.response.ConsumerBusinessResponse;
import com.cts.consumermodule.service.ConsumerService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ConsumerController.class)
public class ConsumerControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ConsumerService consumerService;

	@MockBean
	private ConsumerRepository consumerRepository;

	@MockBean
	private BusinessRepository businessRepository;

	@MockBean
	private PropertyRepository propertyRepository;

	@MockBean
	private AuthClient authClient;

	private static String AuthToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAiLCJleHAiOjE2NTY4NjMwMDIsImlhdCI6MTY1Njg2MjEwMn0.dbmctJujEQ5Ic5uu1lWzfRIHL92D3o0Q6zTYzglrJwc";

	@Test
	public void createConsumerBusinessTest() throws Exception {

		ResponseEntity<String> response = ResponseEntity.ok("Created");
		Mockito.when(consumerService.isSessionValid(Mockito.anyString())).thenReturn(true);
		Mockito.when(consumerService.checkBusinessEligibility(Mockito.any(ConsumerBusinessRequest.class)))
				.thenReturn(true);
		Mockito.<ResponseEntity<?>>when(
				consumerService.createConsumerBusiness(Mockito.any(ConsumerBusinessRequest.class)))
				.thenReturn(response);

		String exampleCourseJson = "{\r\n" + "    \"firstName\" : \"Mahi\",\r\n" + "    \"lastName\" : \"Rocky\",\r\n"
				+ "    \"dob\" : \"10-05-1999\",\r\n" + "    \"email\" : \"Mahi753@gmail.com\",\r\n"
				+ "    \"pan\" : \"CDHKDU9820\",\r\n" + "    \"businessName\" : \"Mahi Enterprises\",\r\n"
				+ "    \"businessType\" : \"Retail\",\r\n" + "    \"businessAge\" : 5,\r\n"
				+ "    \"capitalInvested\" : 700000,\r\n" + "    \"businessTurnover\" : 2000000,\r\n"
				+ "    \"totalEmployees\" : 80,\r\n" + "    \"validity\" : \"75\",\r\n"
				+ "    \"agentName\" : \"Ravi\",\r\n" + "    \"agentId\" : 786\r\n" + "}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createConsumerBusiness")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).header("Authorization", AuthToken)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		//System.out.println(result.getResponse().getContentAsString());
		assertEquals(response.getBody(), result.getResponse().getContentAsString());

	}

	@Test
	public void updateConsumerBusinessTest() throws Exception {

		ResponseEntity<String> response = ResponseEntity.ok("success");

		Mockito.when(consumerService.isSessionValid(Mockito.anyString())).thenReturn(true);
		Mockito.when(consumerRepository.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.when(businessRepository.existsByBusinessName(Mockito.anyString())).thenReturn(true);

		Mockito.<ResponseEntity<?>>when(consumerService.updateConsumerBusiness(Mockito.any(UpdateRequest.class)))
				.thenReturn(response);

		String exampleCourseJson = "{\r\n" + "    \"consumerId\": 1,\r\n" + "    \"firstName\" : \"Mahi\",\r\n"
				+ "    \"lastName\" : \"Babu\",\r\n" + "    \"dob\" : \"10-05-1995\",\r\n"
				+ "    \"email\" : \"Mahi753@gmail.com\",\r\n" + "    \"pan\" : \"CDHKDU9820\",\r\n"
				+ "    \"businessName\" : \"Mahi Enterprises\",\r\n" + "    \"businessType\" : \"Retail\",\r\n"
				+ "    \"businessAge\" : 4,\r\n" + "    \"capitalInvested\" : 700000,\r\n"
				+ "    \"businessTurnover\" : 2500000,\r\n" + "    \"totalEmployees\" : 55,\r\n"
				+ "    \"validity\" : \"75\",\r\n" + "    \"agentName\" : \"Ravi\",\r\n" + "    \"agentId\" : 786\r\n"
				+ "}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/updateConsumerBusiness")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).header("Authorization", AuthToken)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		//System.out.println(result.getResponse().getContentAsString());
		assertEquals(response.getBody(), result.getResponse().getContentAsString());

	}

	@Test
	public void viewConsumerBusinessTest() throws Exception {

		Mockito.when(consumerService.isSessionValid(Mockito.anyString())).thenReturn(true);
		Mockito.when(consumerRepository.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.when(businessRepository.findByConsumerId(Mockito.anyLong())).thenReturn(new Business());

		ConsumerBusinessResponse mockConsumerBusinessResponse = new ConsumerBusinessResponse("fname", "lname", "dob",
				"email", "pan", "bName", "validity", "agentName", (long) 1, (long) 1, "btype", (long) 1, (long) 1,
				(long) 1, (long) 1, (long) 1);

		Mockito.when(consumerService.viewConsumerBusiness(Mockito.anyLong())).thenReturn(mockConsumerBusinessResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/viewConsumerBusiness?consumerId=1")
				.header("Authorization", AuthToken).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		// assertEquals(expected,result.getResponse().getContentAsString());

	}

	@Test
	public void createBusinessPropertyTest() throws Exception {

		ResponseEntity<String> response = ResponseEntity.ok("success");
		
		Mockito.when(consumerService.isSessionValid(Mockito.anyString())).thenReturn(true);
		Mockito.when(consumerService.checkPropertyEligibility(Mockito.any(BusinessInputRequest.class)))
				.thenReturn(true);
		Mockito.when(businessRepository.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.when(consumerRepository.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.<ResponseEntity<?>>when(consumerService.createBusinessProperty(Mockito.any(BusinessInputRequest.class)))
				.thenReturn(response);

		String exampleCourseJson = "{\r\n" + "    \"businessId\" : 1,\r\n" + "    \"consumerId\" : 1,\r\n"
				+ "    \"buildingSqFt\" : \"100sqft\",\r\n" + "    \"buildingType\" : \"Own\",\r\n"
				+ "    \"buildingStoreys\" : \"3\",\r\n" + "    \"buildingAge\" : 10,\r\n"
				+ "    \"costOftheAsset\" : 700000,\r\n" + "    \"salvageValue\" : 500000,\r\n"
				+ "    \"usefulLifeofAsset\" : 3\r\n" + "}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createBusinessProperty")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).header("Authorization", AuthToken)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		//System.out.println(result.getResponse().getContentAsString());
		assertEquals(response.getBody(), result.getResponse().getContentAsString());

	}

	@Test
	public void updateBusinessPropertyTest() throws Exception {

		ResponseEntity<String> response = ResponseEntity.ok("success");

		Mockito.when(consumerService.isSessionValid(Mockito.anyString())).thenReturn(true);
		Mockito.when(propertyRepository.existsByConsumerId(Mockito.anyLong())).thenReturn(true);

		Mockito.<ResponseEntity<?>>when(
				consumerService.updateBusinessProperty(Mockito.any(BusinessUpdateRequest.class))).thenReturn(response);
		
		String exampleCourseJson = "{\r\n"
				+ "    \"consumerId\" : 1,\r\n"
				+ "    \"buildingSqFt\" : \"120sqft\",\r\n"
				+ "    \"buildingType\" : \"Own\",\r\n"
				+ "    \"buildingStoreys\" : \"3\",\r\n"
				+ "    \"buildingAge\" : 11,\r\n"
				+ "    \"costOftheAsset\" : 700000,\r\n"
				+ "    \"salvageValue\" : 1000000,\r\n"
				+ "    \"usefulLifeofAsset\" : 4\r\n"
				+ "}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/updateBusinessProperty")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).header("Authorization", AuthToken)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		//System.out.println(result.getResponse().getContentAsString());
		assertEquals(response.getBody(),result.getResponse().getContentAsString());

	}
	
	@Test
	public void viewConsumerPropertyTest() throws Exception {
		
		Optional<Property> response = Optional.ofNullable(new Property());
		
		Mockito.when(consumerService.isSessionValid(Mockito.anyString())).thenReturn(true);
		
		Mockito.when(consumerRepository.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.when(businessRepository.findByConsumerId(Mockito.anyLong())).thenReturn(new Business());
		Mockito.when(propertyRepository.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(response);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/viewConsumerProperty?consumerId=1&propertyId=1")
				.header("Authorization", AuthToken).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		
		
	}

}
