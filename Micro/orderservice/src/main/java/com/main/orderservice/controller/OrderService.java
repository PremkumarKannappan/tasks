package com.main.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get")
    public ResponseEntity<?> getOrder()
    {
        return new ResponseEntity<>("This is from order", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll()
    {
        String pay= restTemplate.getForObject("http://paymentservice/payment/getPay",String.class);
        String message = "this is a new message from order and from"+pay;
        return  new ResponseEntity<>(message,HttpStatus.OK);
    }
}
