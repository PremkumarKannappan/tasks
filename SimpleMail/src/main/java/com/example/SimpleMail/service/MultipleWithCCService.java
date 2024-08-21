package com.example.SimpleMail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MultipleWithCCService {
    @Autowired
    JavaMailSender mailSender;

    public String sendMultipleMail(String [] toUsers, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("premkumar.kannappan@finsurge.tech");
        message.setTo(toUsers);
        message.setText(body);
        message.setCc("dhayaalan.krishnamoorthi@finsurge.tech");
        message.setSubject(subject);

        mailSender.send(message);
        return "Mail sent Successfully....";
    }

    public String sendMultipleMailAttached(String [] toUsers, String subject, String body, File file1) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        helper.setFrom("premkumar.kannappan@finsurge.tech");
        helper.setTo(toUsers);
        helper.setText(body);
        helper.setCc("dhayaalan.krishnamoorthi@finsurge.tech");
        helper.setSubject(subject);

        helper.addAttachment("Attachment:" ,file1);

        mailSender.send(message);
        return "Mail sent successfully";

    }
}
