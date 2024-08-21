package com.example.demo.controller;

import com.example.demo.entity.StudentDetails;
import com.example.demo.service.StudentDetailsService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentDetailsController
{
    @Autowired
    StudentDetailsService studentDetailsService;

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll()
    {
        List<StudentDetails> newList =  studentDetailsService.findAll();
        System.out.println(newList);
        return new ResponseEntity<>(newList,HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> findById(@PathParam("id") long id)
    {
        return new ResponseEntity<>( studentDetailsService.findOne(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addStudent(@RequestBody StudentDetails studentDetails)
    {
        return new ResponseEntity<>(studentDetailsService.addStudent(studentDetails),HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String name){
        return new ResponseEntity<>(studentDetailsService.getByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam Long id)
    {
        return new ResponseEntity<>(studentDetailsService.deleteById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody StudentDetails student)
    {
        return new ResponseEntity<>(studentDetailsService.updateById(id,student),HttpStatus.OK);
    }

}
