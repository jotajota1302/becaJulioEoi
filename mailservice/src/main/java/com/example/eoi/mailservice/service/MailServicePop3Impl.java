package com.example.eoi.mailservice.service;

import org.springframework.stereotype.Component;

@Component
public class MailServicePop3Impl implements MailService{
	
	@Override
	public void sendMail(String mail, String topic, String content) {
		
		System.out.println("Mando un correo por pop3 a :" + mail );
		
	}

}
