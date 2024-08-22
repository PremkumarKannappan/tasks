package com.example.demo.controller;

import com.example.demo.entity.OneToOne.Person;
import com.example.demo.service.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/add-person")
    public ResponseEntity<?> addPerson(@RequestBody Person person)
    {
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll()
    {
        return new ResponseEntity<>(personService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id)
    {
        return new ResponseEntity<>(personService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody Person person)
    {
        return new ResponseEntity<>(personService.updateById(id,person),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam Long id)
    {
        return new ResponseEntity<>(personService.deleteById(id),HttpStatus.OK);
    }

    @GetMapping("/toCSV")
    public ResponseEntity<InputStreamResource> exportToCSV() {
        ByteArrayInputStream in = personService.exportToCSV();
        SimpleDateFormat date = new SimpleDateFormat("ddMMyyyy_hhmmss");
        String timeStamp = date.format(new Date());
        String fileName = "PERSON_DETAILS_" + timeStamp + ".csv";  // Set the file name with .csv extension

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        headers.add(HttpHeaders.CONTENT_TYPE, "text/csv");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(new InputStreamResource(in));
    }



}
