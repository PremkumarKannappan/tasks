package com.premkumar.order_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PREM_ORDER_ITEMS")
public class Items {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    private String itemPrice;
    private String itemUnit;

    @ManyToOne
    @JsonIgnore
    private Order order;
}
