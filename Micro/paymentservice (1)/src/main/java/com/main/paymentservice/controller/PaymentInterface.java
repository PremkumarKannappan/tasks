package com.main.paymentservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "paymentservice")
public interface PaymentInterface {

    @GetMapping("/payment/getPay")
    ResponseEntity<?> getPay();
}
