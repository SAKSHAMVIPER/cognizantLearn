package com.cts.consumermodule.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessInputRequest {
	
	@NotNull
	private Long businessId;
	
	@NotNull
	private Long consumerId;
	
	@NotBlank
	private String buildingSqFt;
	
	@NotBlank
	private String buildingType;
	
	@NotBlank
	private String buildingStoreys;
	
	@NotNull
	private Long buildingAge;
	
	@NotNull
	private Long costOftheAsset;
	
	@NotNull
	private Long salvageValue;
	
	@NotNull
	private Long usefulLifeofAsset;

}
