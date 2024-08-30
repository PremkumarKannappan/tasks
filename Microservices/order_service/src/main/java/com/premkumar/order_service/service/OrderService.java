package com.premkumar.order_service.service;

import com.premkumar.order_service.entity.Order;
import com.premkumar.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order placeOrder(Order order) {
       return  orderRepository.save(order);
    }
}
