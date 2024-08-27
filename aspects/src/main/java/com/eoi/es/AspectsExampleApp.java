package com.eoi.es;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.eoi.es.service.MyService;
import com.eoi.es.service.MyService2;

@SpringBootApplication
@EnableAspectJAutoProxy
@Configuration
public class AspectsExampleApp implements CommandLineRunner {

	@Autowired
	private MyService service;
	
	@Autowired
	private MyService2 service2;
	
	public static void main(String[] args) {
		SpringApplication.run(AspectsExampleApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		service.doSomething();
		service2.doSomething();
		
	}
	
}
