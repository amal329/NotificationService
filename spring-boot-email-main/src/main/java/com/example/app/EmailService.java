package com.example.app;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;

	public String sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("applicationecommerce982021@gmail.com");
		message.setTo("moleyarcentral@gmail.com");
		message.setSubject("OTP for ECommerce");
		message.setText("Test Body");
		
		javaMailSender.send(message);
		
		return "Mail sent successfully";
	}

	public String sendEmail(EmailDTO emailDTO) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("applicationecommerce982021@gmail.com");
		message.setTo(emailDTO.getEmail());
		message.setSubject("OTP for ECommerce");
		message.setText("OTP is "+emailDTO.getMessage());

		javaMailSender.send(message);

		return "Mail sent successfully";
	}

}
