package com.cts.consumermodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Property")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@NotNull
	@Column(name="BusinessId",unique=true)
	private Long businessId;
	
	@NotNull
	@Column(name="ConsumerId")
	private Long consumerId;
	
	@NotBlank
	@Column(name="Building_SqFt")
	private String buildingSqFt;
	
	@NotBlank
	@Column(name="BuildingType")
	private String buildingType;
	
	@NotBlank
	@Column(name="BuildingStoreys")
	private String buildingStoreys;
	
	@NotNull
	@Column(name="BuildingAge")
	private Long buildingAge;
	
	@NotNull
	@Column(name="PropertyValue")
	private Long propertyValue;
	
	@NotNull
	@Column(name="Cost_Of_the_Asset")
	private Long costOftheAsset;
	
	@NotNull
	@Column(name="Salvage_Value")
	private Long salvageValue;
	
	@NotNull
	@Column(name="Useful_Life_of_Asset")
	private Long usefulLifeofAsset;

	public Property(@NotNull Long businessId, @NotNull Long consumerId, @NotBlank String buildingSqFt,
			@NotBlank String buildingType, @NotBlank String buildingStoreys, @NotNull Long buildingAge,
			@NotNull Long propertyValue, @NotNull Long costOftheAsset, @NotNull Long salvageValue,
			@NotNull Long usefulLifeofAsset) {
		super();
		this.businessId = businessId;
		this.consumerId = consumerId;
		this.buildingSqFt = buildingSqFt;
		this.buildingType = buildingType;
		this.buildingStoreys = buildingStoreys;
		this.buildingAge = buildingAge;
		this.propertyValue = propertyValue;
		this.costOftheAsset = costOftheAsset;
		this.salvageValue = salvageValue;
		this.usefulLifeofAsset = usefulLifeofAsset;
	}

}