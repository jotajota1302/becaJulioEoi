package com.example.eoi.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.eoi.mailservice.service.MailService;

@SpringBootApplication
public class MailServiceApplication implements CommandLineRunner {

	@Autowired
	MailService service;

	@Value("${welcome}")
	String saludo;
	
	public static void main(String[] args) {
		SpringApplication.run(MailServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		System.out.println(saludo);
		
		service.sendMail("JJ", "topic", "aaaaaaaaaaaaaaa");
		
	}

}
