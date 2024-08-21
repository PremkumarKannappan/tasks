package com.example.demo.controller;

import com.example.demo.entity.OneToMany.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController
{
  @Autowired
    EmployeeService employeeService;

  @PostMapping("/add-employee")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
  {
    return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
  }

  @GetMapping("/findAll")
  public ResponseEntity<?> findAll()
  {
    return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
  }

  @GetMapping("/findById/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id)
  {
    return new ResponseEntity<>(employeeService.findById(id),HttpStatus.OK);
  }

  @PutMapping("/updateById/{id}")
  public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody Employee employee)
  {
    return new ResponseEntity<>(employeeService.updateById(id,employee),HttpStatus.OK);
  }

  @DeleteMapping("/deleteById")
  public ResponseEntity<?> deleteById(@RequestParam Long id)
  {
    return new ResponseEntity<>(employeeService.deleteById(id),HttpStatus.OK);
  }
}
