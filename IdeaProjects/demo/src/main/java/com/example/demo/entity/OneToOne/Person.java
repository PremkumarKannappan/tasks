package com.example.demo.entity.OneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PREM_PERSON")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(name = "person_name")
    private String personName;

    @OneToOne(mappedBy = "person")
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
        address.setPerson(this);
    }
}
