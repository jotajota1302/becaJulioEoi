package com.example.eoi.mailservice.service;

public class MailServiceSmtpImpl implements MailService{

	@Override
	public void sendMail(String mail, String topic, String content) {
		
		System.out.println("Mando un correo por smtp a :" + mail);
		
	}

}
