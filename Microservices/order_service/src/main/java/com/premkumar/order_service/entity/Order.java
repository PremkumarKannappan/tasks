package com.premkumar.order_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PREM_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String customerId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private List<Items> items = new ArrayList<>();

    public void setItems(List<Items> items1)
    {
        for(Items item: items1)
        {
            items.add(item);
            item.setOrder(this);
        }
    }
}
