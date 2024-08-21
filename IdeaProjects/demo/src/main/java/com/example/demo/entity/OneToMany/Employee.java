package com.example.demo.entity.OneToMany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PREM_EMPLOYEE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee
{

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(name = "emp_name")
    private String empName;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PhoneNumber> phone;

    public void setPhone(List<PhoneNumber> phone) {
        if(this.phone != null) {
            this.phone.clear();
            // Add new phone numbers to the list
            for (PhoneNumber phn : phone) {
                phn.setEmployee(this);
                this.phone.add(phn);
            }
        }
        else
        {
            this.phone = phone;
            for (PhoneNumber phn : phone) {
                phn.setEmployee(this);
            }
        }
    }
}
