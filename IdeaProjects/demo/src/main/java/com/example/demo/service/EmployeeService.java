package com.example.demo.service;

import com.example.demo.entity.OneToMany.Employee;
import com.example.demo.entity.OneToMany.PhoneNumber;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee)
    {
       return  employeeRepository.save(employee);
    }

    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id)
    {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateById(Long id, Employee employee) {
        return employeeRepository.findById(id).map(existingEmployee -> {
            // Update the employee's name
            existingEmployee.setEmpName(employee.getEmpName());

            // Update the phone list
            List<PhoneNumber> newPhoneList = employee.getPhone();
            if (newPhoneList != null) {
                // Clear the existing phone list
                existingEmployee.getPhone().clear();

                // Add each phone number and set the employee reference
                for (PhoneNumber phone : newPhoneList) {
                    phone.setEmployee(existingEmployee); // Set the bidirectional relationship
                    existingEmployee.getPhone().add(phone); // Add the phone to the existing list
                }
            }

            // Save and return the updated employee
            return employeeRepository.save(existingEmployee);
        }).orElseGet(() -> {
            // If the employee doesn't exist, create a new one
            employee.setEmpId(id);
            return employeeRepository.save(employee);
        });
    }


    public String deleteById(Long id)
    {
         employeeRepository.deleteById(id);
         return "Deleted the data of id"+id;
    }
}
