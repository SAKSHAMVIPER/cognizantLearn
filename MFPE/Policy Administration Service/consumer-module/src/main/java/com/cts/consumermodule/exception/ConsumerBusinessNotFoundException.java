package com.cts.consumermodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "No Consumer Found!!")
public class ConsumerBusinessNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
}


