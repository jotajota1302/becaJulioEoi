package com.eoi.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanLoadingApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(BeanLoadingApplication.class, args);
	}

	@Autowired	
	MyService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("mi aplicacion funciona");
		service.doSomething();
		
	}
	
	@Bean
	@ConditionalOnProperty(prefix = "",name = "loadbean",havingValue = "one")
	MyService getOne() {
		
		return new MyServiceOne();
	}
	
	@Bean
	@ConditionalOnProperty(prefix = "",name = "loadbean",havingValue = "two")
	MyService getTwo() {
		
		return new MyServiceTwo();
	}

}
