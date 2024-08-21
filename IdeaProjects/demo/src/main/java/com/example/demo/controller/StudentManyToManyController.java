package com.example.demo.controller;

import com.example.demo.entity.ManyToMany.Library;
import com.example.demo.entity.ManyToMany.Student;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.StudentManyToManyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.LibraryService;
import com.example.demo.service.StudentManyToManyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/library")
public class StudentManyToManyController {

    @Autowired
    LibraryService libraryService;

    @Autowired
    StudentManyToManyRepository studentRepository;

    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestParam Long studentId,@RequestParam String studentName, @RequestBody List<Library> library)
    {
        List<Library> result = new ArrayList<>();
        Student stud = new Student();
        stud.setStudentId(studentId);
        stud.setStudentName(studentName);
        studentRepository.save(stud);
        for(Library lib:library)
        {
            lib.setStudents(stud);
            result.add(libraryService.addLibrary(lib));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/add-library")
    public ResponseEntity<?> addLibrary(@RequestBody Library library)
    {
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }
}
