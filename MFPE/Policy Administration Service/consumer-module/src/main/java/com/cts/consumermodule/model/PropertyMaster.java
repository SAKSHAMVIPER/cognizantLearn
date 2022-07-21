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
@Table(name = "Property_Master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotBlank
	@Column(name = "BuildingType")
	private String buildingType;

	@NotNull
	@Column(name = "BuildingAge")
	private Long buildingAge;

}
