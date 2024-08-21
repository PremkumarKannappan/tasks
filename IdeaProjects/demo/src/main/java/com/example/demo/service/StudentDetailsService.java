package com.example.demo.service;

import com.example.demo.entity.StudentDetails;
import com.example.demo.repository.StudentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDetailsService
{
    @Autowired
    StudentDetailsRepository studentDetailsRepository;

    public Optional<StudentDetails> findOne(long id)
    {
        return studentDetailsRepository.findById(id);
    }

    public StudentDetails
    addStudent(StudentDetails studentDetails)
    {

        return studentDetailsRepository.save(studentDetails);
        
    }

    public List<StudentDetails> findAll()
    {
        return new ArrayList<>(studentDetailsRepository.findAll());
    }

    public StudentDetails getByName(String name) {
        return studentDetailsRepository.getByName(name);
    }

    public String deleteById(Long id) {
         studentDetailsRepository.deleteById(id);
         return "Student details of the id "+id+" is deleted successfully";
    }

    public StudentDetails updateById(Long id, StudentDetails student) {

          return studentDetailsRepository.findById(id).map(newStudent ->
          {
           newStudent.setStudentName(student.getStudentName());
           return studentDetailsRepository.save(newStudent);
           }).orElseGet(()->
          {
              student.setId(id);
              return studentDetailsRepository.save(student);
          });

    }
}
