package com.premkumar.payment_service.service;

import com.premkumar.payment_service.entity.Payment;
import com.premkumar.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addPayment(Payment payment)
    {
        Random rd = new Random();
        payment.setStatus(rd.nextBoolean());
        return paymentRepository.save(payment);
    }

    public List<Payment> findPayment(Long orderId)
    {
     return  paymentRepository.findByOrderId(orderId);
    }
}
