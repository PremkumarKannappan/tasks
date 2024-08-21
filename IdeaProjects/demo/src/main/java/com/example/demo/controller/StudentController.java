package com.example.demo.controller;

import com.example.demo.entity.ManyToOne.Department;
import com.example.demo.entity.ManyToOne.StudentForManyToOne;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.*;

@Controller
@RequestMapping("/department")
public class StudentController
{
    @Autowired
    StudentService studentService;
    @Autowired
    DepartmentRepository departmentRepository;


    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestParam Long depId,@RequestParam String depName, @RequestBody Map<String,List<StudentForManyToOne>> studentDetails)
    {
        List<StudentForManyToOne> students = studentDetails.get("student");
        List<StudentForManyToOne> result = new ArrayList<>();
        Department dept = new Department();
        dept.setDepId(depId);
        dept.setDepName(depName);
        departmentRepository.save(dept);
        if(!students.isEmpty()) {
            for (StudentForManyToOne stud : students) {

                stud.setDepartment(dept);
                result.add(studentService.addStudent(stud));
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>("No students found",HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<>(studentService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id)
    {
        return new ResponseEntity<>(studentService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam Long id)
    {
        return new ResponseEntity<>(studentService.deleteById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateById(@RequestParam Long id,@RequestBody StudentForManyToOne student)
    {
        return new ResponseEntity<>(studentService.updateById(id,student),HttpStatus.OK);
    }
}
