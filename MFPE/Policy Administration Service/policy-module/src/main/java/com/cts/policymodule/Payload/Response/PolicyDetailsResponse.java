package com.cts.policymodule.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDetailsResponse {

    @NotNull
    private long consumerId;

    @NotBlank
    private String policyId;

    @NotBlank
    private String propertyType;

    @NotBlank
    private String consumerType;

    @NotBlank
    private String assuredSum;

    @NotBlank
    private String tenure;

    @NotNull
    private long businessValue;

    @NotNull
    private long propertyValue;

    @NotBlank
    private String baseLocation;

    @NotBlank
    private String type;

    @NotNull
    private long businessId;

    @NotBlank
    private String paymentDetails;

    @NotBlank
    private String acceptanceStatus;

    @NotBlank
    private String policyStatus;

    @NotBlank
    private String effectiveDate;

    @NotBlank
    private String coveredSum;

    @NotBlank
    private String duration;

    @NotBlank
    private String acceptedQuote;

}
