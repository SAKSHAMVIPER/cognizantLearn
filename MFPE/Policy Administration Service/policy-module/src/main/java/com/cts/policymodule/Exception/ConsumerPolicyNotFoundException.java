package com.cts.policymodule.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Consumer Policy Not Found")
public class ConsumerPolicyNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public ConsumerPolicyNotFoundException(String message) {
        super(message);
    }
}
