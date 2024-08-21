package com.example.demo.entity.ManyToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PREM_DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id")
    private Long depId;

    @Column(name = "dep_name")
    private String depName;

    @OneToMany(mappedBy = "department")
    private List<StudentForManyToOne> student = new ArrayList<>();

    public void addStudent(StudentForManyToOne studentForManyToOne) {
        student.add(studentForManyToOne);
        studentForManyToOne.setDepartment(this);
    }
}