package com.example.demo.entity.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PREM_ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name = "ADDRESS")
    private String address;

    @OneToOne
    @JoinColumn(name = "person",referencedColumnName = "person_id")
    @JsonIgnore
    private Person person;

}