package com.premkumar.order_service.controller;

import com.premkumar.order_service.entity.Order;
import com.premkumar.order_service.entity.OrderDto;
import com.premkumar.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place-order")
    public ResponseEntity<?> placeOrder(@RequestBody OrderDto orderDto)
    {
        return new ResponseEntity<>(orderService.placeOrder(orderDto), HttpStatus.OK);
    }
}
