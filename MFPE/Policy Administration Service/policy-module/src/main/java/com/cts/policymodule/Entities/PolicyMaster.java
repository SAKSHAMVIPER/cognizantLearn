package com.cts.policymodule.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Policy_Master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private long ID;

    @NotBlank
    @Column(name = "Policy_ID")
    private String policyId;

    @Column(name = "Property_Type")
    private String propertyType;

    @Column(name = "Consumer_Type")
    private String consumerType;

    @Column(name = "Assured_Sum")
    private String assuredSum;

    @Column(name = "Tenure")
    private String tenure;

    @Column(name = "Business_Value")
    private long businessValue;

    @Column(name = "Property_Value")
    private long propertyValue;

    @Column(name = "Base_Location")
    private String baseLocation;

    @Column(name = "Type")
    private String type;

}
