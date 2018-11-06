package com.fabiose.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MainEurekaServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MainEurekaServerApplication.class, args);
	}

}
