package com.cts.policymodule.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerBusinessDetails {

	@NotNull
	private long consumerId;
	
	@NotNull
	private long businessId;
	
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
	
	@NotBlank
	private String totalEmployees;

}
