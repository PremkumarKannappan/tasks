package com.example.demo.controller;

import com.example.demo.entity.OneToOne.Person;
import com.example.demo.service.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
