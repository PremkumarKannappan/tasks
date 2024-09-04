package com.premkumar.payment_service.repository;

import com.premkumar.payment_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
   public List<Payment> findByOrderId(Long orderId);
}
