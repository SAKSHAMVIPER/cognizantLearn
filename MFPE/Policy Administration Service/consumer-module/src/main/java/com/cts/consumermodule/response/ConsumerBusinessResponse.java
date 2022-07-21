package com.cts.consumermodule.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerBusinessResponse {

	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String dob;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String pan;
	
	@NotBlank
	private String businessName;
	
	@NotBlank
	private String validity;
	
	@NotBlank
	private String agentName;
	
	@NotBlank
	private Long agentId;
	
	@NotNull
	private Long consumerId;
	
	@NotBlank
	private String businessType;
	
	@NotNull
	private Long businessAge;
	
	@NotNull
	private Long totalEmployees;
	
	@NotNull
	private Long capitalInvested;
	
	@NotNull
	private Long businessTurnover;
	
	@NotNull
	private long businessId;
}
