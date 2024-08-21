package com.example.demo.entity.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PREM_STUD")
public class StudentForManyToOne {
    @Id
    @Column(name = "stud_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stud_name")
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "dept_id" ,referencedColumnName = "dep_id")
    @JsonIgnore
    private Department department;
}
