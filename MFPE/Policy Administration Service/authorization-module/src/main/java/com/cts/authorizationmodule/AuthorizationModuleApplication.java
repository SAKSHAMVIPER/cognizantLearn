package com.cts.authorizationmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AuthorizationModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationModuleApplication.class, args);
	}

}
