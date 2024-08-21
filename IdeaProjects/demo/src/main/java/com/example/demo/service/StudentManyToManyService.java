package com.example.demo.service;

import com.example.demo.entity.ManyToMany.Student;
import com.example.demo.repository.StudentManyToManyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentManyToManyService {

    @Autowired
    StudentManyToManyRepository studentManyToManyRepository;

    public Student addStudent(Student student)
    {
        return studentManyToManyRepository.save(student);
    }
}
