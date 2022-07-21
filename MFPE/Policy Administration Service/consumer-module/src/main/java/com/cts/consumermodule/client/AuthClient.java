package com.cts.consumermodule.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.consumermodule.model.AuthResponse;

@FeignClient(name="authorization-service", url="${AUTHORIZATION_SERVICE:http://localhost:8080}")
public interface AuthClient {

	@GetMapping(value="/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);
}
