package com.eoi.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiClientApplication.class, args);
	}

}
