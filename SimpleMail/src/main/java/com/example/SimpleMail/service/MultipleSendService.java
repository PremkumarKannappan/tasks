package com.example.SimpleMail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MultipleSendService {

    @Autowired
    JavaMailSender mailSender;

    Logger log = LoggerFactory.getLogger(MultipleSendService.class);

    @Scheduled(cron = "0 */2 * * * *")
    public String sendMultipleMail()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("premkumar.kannappan@finsurge.tech");
        String [] toUsers = {"premkumar24kannappan@gmail.com","rajeshgpro143@gmail.com"};
        String body = "Body of the mail sent from api";
        String subject = "this is the subject";
        message.setTo(toUsers);
        message.setText(body);
        message.setSubject(subject);
        log.info("Started");
        mailSender.send(message);
        return "Mail sent Successfully....";
    }

    public String sendMultipleMailAttached(String [] toUsers, String subject, String body, File file1) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        helper.setFrom("premkumar.kannappan@finsurge.tech");
        helper.setTo(toUsers);
        helper.setText(body);
        helper.setSubject(subject);

        helper.addAttachment("Attachment:" ,file1);

        mailSender.send(message);
        return "Mail sent successfully";

    }
}
