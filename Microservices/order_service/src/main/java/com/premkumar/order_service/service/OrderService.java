package com.premkumar.order_service.service;

import com.premkumar.order_service.entity.Order;
import com.premkumar.order_service.entity.OrderDto;
import com.premkumar.order_service.entity.Payment;
import com.premkumar.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpRequest;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderDto placeOrder(OrderDto orderDto) {

        Order order = orderDto.getOrder();
        Order resOrder = orderRepository.save(order);

        Payment payment = orderDto.getPayment();
        payment.setOrderId(order.getOrderId());

        //Payment resPay = restTemplate.postForObject("http://PAYMENT_SERVICE/payment/new", payment, Payment.class);
        return new OrderDto(resOrder, payment);
    }

}
