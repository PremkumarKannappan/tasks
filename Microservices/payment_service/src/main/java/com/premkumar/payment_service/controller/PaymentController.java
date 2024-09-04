package com.premkumar.payment_service.controller;

import com.premkumar.payment_service.entity.Payment;
import com.premkumar.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/new")
    public ResponseEntity<?> addPayment(@RequestBody Payment payment)
    {
        return new ResponseEntity<>(paymentService.addPayment(payment), HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findPayment(@RequestParam Long orderId)
    {
        return  new ResponseEntity<>(paymentService.findPayment(orderId),HttpStatus.OK);
    }
}
