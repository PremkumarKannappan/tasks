package com.example.SimpleMail.controller;

import com.example.SimpleMail.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/mail")
public class MailSenderController {

    @Autowired
    MailSenderService mailSenderService;

    @PostMapping("/single")
    public void sendMail(@RequestBody Map<String,String> mailDetails)
    {
        String toUser = mailDetails.get("toUser");
        String body = mailDetails.get("body");
        String subject = mailDetails.get("subject");
        mailSenderService.sendMail(toUser,subject,body);
    }
}
