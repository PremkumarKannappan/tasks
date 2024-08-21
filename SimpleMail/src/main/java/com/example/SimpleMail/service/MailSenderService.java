package com.example.SimpleMail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService
{
    @Autowired
    JavaMailSender mailSender;

    public void sendMail(String toUser,String subject,String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("premkumar.kannappan@finsurge.tech");
        message.setTo(toUser);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail sent successfully....");
    }
}
