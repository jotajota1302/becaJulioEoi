package com.eoi.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BooksApp {

	public static void main(String[] args) {
		SpringApplication.run(BooksApp.class, args);
	}	

}
