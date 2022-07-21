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
@Table(name="Business")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Business {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@NotNull
	@Column(name="ConsumerId")
	private Long consumerId;
	
	@NotBlank
	@Column(name="BusinessName",unique=true)
	private String businessName;
	
	@NotBlank
	@Column(name="BusinessType")
	private String businessType;
	
	@NotNull
	@Column(name="BusinessAge")
	private Long businessAge;
	
	@NotNull
	@Column(name="TotalEmployees")
	private Long totalEmployees;
	
	@NotNull
	@Column(name="CapitalInvested")
	private Long capitalInvested;
	
	@NotNull
	@Column(name="BusinessTurnover")
	private Long businessTurnover;

	public Business(@NotNull Long consumerId, @NotNull String businessName, @NotNull String businessType,
			@NotNull Long businessAge, @NotNull Long totalEmployees, @NotNull Long capitalInvested,
			@NotNull Long businessTurnover) {
		super();
		this.consumerId = consumerId;
		this.businessName = businessName;
		this.businessType = businessType;
		this.businessAge = businessAge;
		this.totalEmployees = totalEmployees;
		this.capitalInvested = capitalInvested;
		this.businessTurnover = businessTurnover;
	}

}
