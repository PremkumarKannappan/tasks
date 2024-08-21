package com.example.demo.entity.ManyToMany;

import com.example.demo.entity.OneToMany.PhoneNumber;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PREM_STUDENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student
{
    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @ManyToMany(mappedBy = "students")
    private List<Library> libraryList = new ArrayList<>();

    public void setLibraryList(Library lib)
    {
        this.libraryList.add(lib);
        lib.getStudents().add(this);
    }

}
