package com.fabiose.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainCurrencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainCurrencyServiceApplication.class, args);
	}
	
}
