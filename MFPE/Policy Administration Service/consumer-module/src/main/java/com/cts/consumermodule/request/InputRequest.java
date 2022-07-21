package com.cts.consumermodule.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InputRequest {
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String pan;
	
	@NotBlank
	private String dob;
	
	@NotBlank
	private String businessName;
	
	@NotBlank
	private String businessType;
	
	@NotNull
	private Long capitalInvested;
	
	@NotBlank
	private String validity;
	
	@NotNull
	private Long agentId;
	
	@NotBlank
	private String agentName;
	
	@NotNull
	private Long businessTurnover;
	
	@NotNull
	private Long businessAge;
	
	@NotNull
	private String totalEmployees;

}
