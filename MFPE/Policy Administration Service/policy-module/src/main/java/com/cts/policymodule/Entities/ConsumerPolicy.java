package com.cts.policymodule.Entities;

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

@Entity
@Table(name = "Consumer_Policy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Column(name = "Policy_ID")
    private String policyId;

    @NotNull
    @Column(name = "Business_ID")
    private Long businessId;

    @NotNull
    @Column(name = "Consumer_ID",unique=true)
    private Long consumerId;

    @Column(name = "Property_Type")
    private String propertyType;

    @Column(name = "Consumer_Type")
    private String consumerType;

    @Column(name = "Assured_Sum")
    private String assuredSum;

    @Column(name = "Tenure")
    private String tenure;

    @Column(name = "Business_Value")
    private Long businessValue;

    @Column(name = "Property_Value")
    private Long propertyValue;

    @Column(name = "Payment_Details")
    private String paymentDetails;

    @Column(name = "Acceptance_Status")
    private String acceptanceStatus;

    @Column(name = "Effective_Date")
    private String effectiveDate;

    @Column(name = "Covered_Sum")
    private String coveredSum;

    @Column(name = "Duration")
    private String duration;

    @Column(name = "Base_Location")
    private String baseLocation;

    @Column(name = "Type")
    private String type;

    @NotBlank
    @Column(name = "Accepted_Quotes")
    private String acceptedQuote;

    @NotBlank
    @Column(name = "Status")
    private String policyStatus;

    public ConsumerPolicy(@NotNull Long consumerId, @NotNull Long businessId, @NotBlank @Size(max = 10) String policyStatus, @NotBlank @Size(max = 15) String acceptedQuote) {
        super();
        this.consumerId = consumerId;
        this.businessId = businessId;
        this.policyStatus = policyStatus;
        this.acceptedQuote = acceptedQuote;
    }

}