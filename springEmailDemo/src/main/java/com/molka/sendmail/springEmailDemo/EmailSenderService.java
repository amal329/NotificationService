package com.molka.sendmail.springEmailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailOTP(String toEmail,String subject)
    {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("moleyarcentral@gmail.com");
        message.setTo(toEmail);
        message.setText((int)(Math.random()*(10000-1000)+1000)+" is your OTP");
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("mail Sent");
    }
}
