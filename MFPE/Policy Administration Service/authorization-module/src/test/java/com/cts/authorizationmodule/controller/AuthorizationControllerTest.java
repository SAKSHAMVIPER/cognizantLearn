package com.cts.authorizationmodule.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cts.authorizationmodule.model.UserModel;
import com.cts.authorizationmodule.service.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorizationControllerTest {

	private static String AuthToken = 
			"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAiLCJleHAiOjE2NTY5NDI3NDgsImlhdCI6MTY1Njk0MTg0OH0.ROvPisQ464NSsahQ-SzO3U_3uW_z-24wYUG7r9ki56s";	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AuthController authController;
	
	@MockBean
	JwtUtil jwtUtil;
	@Test
	public void contextLoads() {

		assertNotNull(authController);

	}

	@Test
	public void loginTestSuccess() throws Exception {
		UserModel admin = new UserModel("100", "sanjive", "pass", "");

		ResultActions actions = mockMvc
				.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(admin)));
		actions.andExpect(status().isOk());
	}

	@Test
	public void loginTestFail() throws Exception {
		UserModel admin = new UserModel("randomUser", "randomUser", "randomUser", "randomUser");

		ResultActions actions = mockMvc
				.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(admin)));
		actions.andExpect(status().isForbidden());
		actions.andExpect(status().reason("Access Denied"));
	}

//	@Test
//	public void validateTestSuccess() throws Exception {
//		ResultActions actions = mockMvc.perform(get("/validate").header("Authorization", "Bearer " + AuthToken));
//
//		actions.andExpect(status().isOk());
//
//	}

	@Test
	public void validateTestFail() throws Exception {
		ResultActions actions = mockMvc.perform(get("/validate").header("Authorization", "randomToken"));

		actions.andExpect(status().isForbidden());

	}
	
}
