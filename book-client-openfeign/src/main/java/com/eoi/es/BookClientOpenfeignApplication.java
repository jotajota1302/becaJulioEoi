package com.eoi.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookClientOpenfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookClientOpenfeignApplication.class, args);
	}

}
