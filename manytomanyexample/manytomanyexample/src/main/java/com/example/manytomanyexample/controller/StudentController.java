package com.example.manytomanyexample.controller;

import com.example.manytomanyexample.entity.Student;
import com.example.manytomanyexample.service.BookService;
import com.example.manytomanyexample.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @Autowired
    Environment environment;



    @Value("${app.name}")
    private String appName;
    @PostMapping(value = "/add-student")
    public ResponseEntity<?> addStudent(@RequestBody Student student) throws JsonProcessingException {

        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam Long id)
    {
        System.out.println(appName);
        return new ResponseEntity<>(studentService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll()
    {
        System.out.println(environment.getProperty("app.name"));
        return new ResponseEntity<>(studentService.findAll(),HttpStatus.OK);
    }


}
