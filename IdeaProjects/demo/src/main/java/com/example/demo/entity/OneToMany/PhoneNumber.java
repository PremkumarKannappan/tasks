package com.example.demo.entity.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PREM_PHONE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber
{
    @Id
    @Column(name = "phn_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phnId;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id",referencedColumnName = "emp_id")
    @JsonIgnore
    private Employee employee;

}
