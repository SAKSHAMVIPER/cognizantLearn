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
@Table(name="Consumer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@NotBlank
	@Column(name="FirstName")
	private String firstName;
	
	@NotBlank
	@Column(name="LastName")
	private String lastName;
	
	@NotBlank
	@Column(name="DOB")
	private String dob;
	
	@NotBlank
	@Column(name="Email")
	private String email;
	
	@NotBlank
	@Column(name="PAN",unique=true)
	private String pan;
	
	@NotBlank
	@Column(name="BusinessName")
	private String businessName;
	
	@NotBlank
	@Column(name="Validity_Of_Consumer")
	private String validity;
	
	@NotBlank
	@Column(name="AgentName")
	private String agentName;
	
	@NotNull
	@Column(name="AgentId")
	private Long agentId;

	public Consumer(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String dob, @NotBlank String email,
			@NotBlank String pan, @NotBlank String businessName, @NotBlank String validity, @NotBlank String agentName,
			@NotBlank Long agentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.pan = pan;
		this.businessName = businessName;
		this.validity = validity;
		this.agentName = agentName;
		this.agentId = agentId;
	}

	
}