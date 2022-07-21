package com.cts.policymodule.Payload.Request;

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
public class IssuePolicyRequest {

    @NotBlank
    private String policyId;

    @NotNull
    private long consumerId;

    @NotNull
    private long businessId;

    @NotBlank
    private String paymentDetails;

    @NotBlank
    private String acceptanceStatus;

}
