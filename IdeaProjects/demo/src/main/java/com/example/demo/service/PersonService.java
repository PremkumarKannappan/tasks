package com.example.demo.service;

import com.example.demo.entity.OneToOne.Address;
import com.example.demo.entity.OneToOne.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PersonService
{
    @Autowired
    PersonRepository personRepository;

    public Person addPerson(Person person)
    {
        return personRepository.save(person);
    }

    public List<Person> findAll()
    {
        return personRepository.findAll();
    }

    public Person findById(Long id)
    {
        return personRepository.findById(id).orElse(null);
    }

    public Person updateById(Long id,Person person)
    {
        return personRepository.findById(id).map(newPerson ->
        {
            newPerson.setPersonName(person.getPersonName());
            newPerson.setAddress(person.getAddress());
            return personRepository.save(newPerson);
        }).orElseGet(()->
        {
            person.setPersonId(id);
            return personRepository.save(person);
        });
    }

    public String deleteById(Long id) {
        personRepository.deleteById(id);
        return "Student details of the id "+id+" is deleted successfully";
    }

    public ByteArrayInputStream exportToCSV() {
        List<Person> persons = personRepository.findAll();
        SimpleDateFormat date = new SimpleDateFormat("ddMMyyyy_hhmmss");
        String timeStamp = date.format(new Date());
        String[] columns = {"ID", "PERSON_NAME"};

        // Using StringBuilder to build CSV content
        StringBuilder csvContent = new StringBuilder();

        // Adding header row
        csvContent.append(String.join(",", columns)).append("\n");

        // Adding data rows
        for (Person per : persons) {
            csvContent.append(per.getPersonId()).append(",")
                    .append(per.getPersonName()).append("\n");
        }

        // Converting StringBuilder to ByteArrayInputStream
        return new ByteArrayInputStream(csvContent.toString().getBytes());
    }


}
