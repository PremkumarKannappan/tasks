package com.example.manytomanyexample.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

@Entity

@Table(name = "PREM_STUDENT_MANY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    private String studentName;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "PREM_STUDENT_BOOKS",
            joinColumns = {@JoinColumn (name = "student_id",referencedColumnName = "student_id")},
            inverseJoinColumns ={@JoinColumn (name = "book_id",referencedColumnName = "book_id")})
    private Set<Books> books;
}
