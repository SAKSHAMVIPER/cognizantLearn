package com.cts.quotesmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages={"com.cts"})
@EnableJpaRepositories
@EnableFeignClients
@EnableDiscoveryClient
public class QuotesModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotesModuleApplication.class, args);
	}

}
