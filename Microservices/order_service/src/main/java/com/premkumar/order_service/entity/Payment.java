package com.premkumar.order_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Long paymentId;

    private Double amount;

    private Long orderId;

    private boolean status;
}
