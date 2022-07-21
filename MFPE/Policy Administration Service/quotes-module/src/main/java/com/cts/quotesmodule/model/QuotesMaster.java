package com.cts.quotesmodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quotes")
public class QuotesMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@NotNull
	@Column(name = "Business_Value")
	private long businessValue;
	
	@NotNull
	@Column(name = "Property_Value")
	private long propertyValue;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "Property_Type")
	private String propertyType;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "Quotes")
	private String quote;

}
