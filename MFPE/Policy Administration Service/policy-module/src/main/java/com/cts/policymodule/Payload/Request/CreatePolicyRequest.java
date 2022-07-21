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
public class CreatePolicyRequest {

    @NotNull
    private long consumerId;

    @NotBlank
    private String acceptedQuotes;

}
