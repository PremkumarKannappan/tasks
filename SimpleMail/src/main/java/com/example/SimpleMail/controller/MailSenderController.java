package com.example.SimpleMail.controller;

import com.example.SimpleMail.service.MailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Map;

@Controller
@RequestMapping("/mail")
public class MailSenderController {

    @Autowired
    MailSenderService mailSenderService;

    @PostMapping("/single")
    public ResponseEntity<?> sendMail(@RequestBody Map<String,String> mailDetails)
    {
        String toUser = mailDetails.get("toUser");
        String body = mailDetails.get("body");
        String subject = mailDetails.get("subject");
        return new ResponseEntity<>(mailSenderService.sendMail(toUser,subject,body), HttpStatus.OK);
    }


    @PostMapping("/withAttachment")
    public ResponseEntity<?> sendMailAttached() throws MessagingException {
        String toUser = "premkumar24kannappan@gmail.com";
        String body = "Body of the mail sent from api";
        String subject = "this is the subject";

        File file1 = new File("/home/premkumar/Documents/GitHub/tasks/StudentData.xlsx");

        return new ResponseEntity<>(mailSenderService.sendMailAttached(toUser,subject,body,file1),HttpStatus.OK);
    }
}
