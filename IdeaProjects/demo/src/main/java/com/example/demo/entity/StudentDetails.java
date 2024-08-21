package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "STUDENT_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STUDENT_NAME")
    private String studentName;



}
