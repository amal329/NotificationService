package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class EmailController {
	
	@Autowired
	com.example.app.EmailService emailService;

	@GetMapping("/sendMailTo")
	public String sendEmail(@RequestBody EmailDTO emailDTO){
		emailDTO.setMessage(Integer.toString((int)(Math.random()*(9999-1000)+1000)));
		return emailService.sendEmail(emailDTO);
	}

	@GetMapping("/sendEmail")
	public String sendEmail() {
		return emailService.sendEmail();
	}
	

	
}
