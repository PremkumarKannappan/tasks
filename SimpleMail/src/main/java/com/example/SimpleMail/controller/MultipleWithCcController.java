package com.example.SimpleMail.controller;

import com.example.SimpleMail.service.MultipleWithCCService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@RequestMapping("/multipleCc")
public class MultipleWithCcController
{
    @Autowired
    MultipleWithCCService sendService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMultipleMail()
    {
        String [] toUser = {"premkumar24kannappan@gmail.com","rajeshgpro143@gmail.com"};
        String body = "Body of the mail sent from api";
        String subject = "this is the subject";
        return new ResponseEntity<>(sendService.sendMultipleMail(toUser,subject,body), HttpStatus.OK);
    }

    @PostMapping("/sendAttached")
    public ResponseEntity<?> sendMultipleMailAttached() throws MessagingException {
        String [] toUser = {"premkumar24kannappan@gmail.com","rajeshgpro143@gmail.com"};
        String body = "Body of the mail sent from api";
        String subject = "this is the subject";

        File file1 = new File("/home/premkumar/Documents/GitHub/tasks/StudentData.xlsx");

        return new ResponseEntity<>(sendService.sendMultipleMailAttached(toUser,subject,body,file1), HttpStatus.OK);
    }

}
