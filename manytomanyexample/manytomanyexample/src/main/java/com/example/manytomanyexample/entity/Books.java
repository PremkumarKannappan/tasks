package com.example.manytomanyexample.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "PREM_BOOK_MANY")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    private String bookName;
    private String author;

    @ManyToMany(mappedBy = "books",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Student> students;
}
