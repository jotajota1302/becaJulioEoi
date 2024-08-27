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
	
	@Autowired
	Labels labels;
	
	@Override
	public void run(String... args) throws Exception {
		
				
		System.out.println("Selecciona un idioma:");
		//lees la respuesta
		
		//cambias las labels al idioma en cuestion y vuelves al run
		
		service.doSomething();
		
	}
	
	@Bean
	@ConditionalOnProperty(prefix = "service",name = "zone",havingValue = "ASIA")
	MyService getOne() {
		
		return new AsiaService();
	}
	
	@Bean
	@ConditionalOnProperty(prefix = "service",name = "zone",havingValue = "EU")
	MyService getTwo() {
		
		return new EuService();
	}
	
	@Bean
	@ConditionalOnProperty(prefix = "service",name = "zone",havingValue = "USA")
	MyService getThree() {
		
		return new UsaService();
	}

}
