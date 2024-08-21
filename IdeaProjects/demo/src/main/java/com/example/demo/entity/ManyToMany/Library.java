package com.example.demo.entity.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PREM_LIBRARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library
{
    @Id
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_name")
    private String bookName;

    @ManyToMany
    @JoinTable(
            name = "Student_Library",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="book_id")
    )
    private List<Student> students = new ArrayList<>();

    public void setStudents (Student student)
    {
        this.students.add(student);
        student.getLibraryList().add(this);
    }
}
