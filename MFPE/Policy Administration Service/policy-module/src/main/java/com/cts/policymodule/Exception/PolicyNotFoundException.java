package com.cts.policymodule.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Policy Not Found")
public class PolicyNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public PolicyNotFoundException(String message) {
        super(message);
    }
}
