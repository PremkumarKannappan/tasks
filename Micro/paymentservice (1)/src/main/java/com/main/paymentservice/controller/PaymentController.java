package com.main.paymentservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController implements PaymentInterface{


    @GetMapping("/getPay")
    @Override
    public ResponseEntity<?> getPay() {
        return new ResponseEntity<>("this msg generated from payment service", HttpStatus.OK);
    }
}
