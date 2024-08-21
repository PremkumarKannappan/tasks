package com.example.manytomanyexample.service;

import com.example.manytomanyexample.entity.Student;
import com.example.manytomanyexample.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ObjectMapper objectMapper;

    public Student findById(Long id)
    {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findAll ()
    {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) throws JsonProcessingException {
        String stringJson = objectMapper.writeValueAsString(student);
        System.out.println(stringJson);
        Student stud = objectMapper.readValue(stringJson,Student.class);
        System.out.println(stud);
        System.out.println(stud.getStudentId());
        return studentRepository.save(student);
    }
}
