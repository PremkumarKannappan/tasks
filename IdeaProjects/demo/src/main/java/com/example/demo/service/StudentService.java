package com.example.demo.service;

import com.example.demo.entity.ManyToOne.Department;
import com.example.demo.entity.ManyToOne.StudentForManyToOne;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public StudentForManyToOne addStudent(StudentForManyToOne student)
    {
        return studentRepository.save(student);
    }

    public List<StudentForManyToOne> findAll()
    {
        return studentRepository.findAll();
    }

    public StudentForManyToOne findById(Long id)
    {
        return studentRepository.findById(id).orElse(null);
    }

    public String deleteById(Long id)
    {
        studentRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public StudentForManyToOne updateById(Long id,StudentForManyToOne student)
    {
        return studentRepository.findById(id).map(newStudent ->
        {
            newStudent.setStudentName(student.getStudentName());
            newStudent.setDepartment(student.getDepartment());
            return studentRepository.save(newStudent);
        }
        ).orElseGet(() ->
        {
            student.setId(id);
            return studentRepository.save(student);
        }
        );
    }

    public Department saveDepartmentWithStudents(Department department) {

        // Ensure that each student in the department is properly linked to the department
        for (StudentForManyToOne student : department.getStudent()) {
            student.setDepartment(department);
        }
        // Save the department, which will also save the associated students due to CascadeType.ALL
        return departmentRepository.save(department);
    }

}


