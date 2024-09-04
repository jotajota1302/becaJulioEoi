package com.eoi.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClienteApplication.class, args);
	}

}
