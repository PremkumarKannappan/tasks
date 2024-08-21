package com.example.demo.service;

import com.example.demo.entity.OneToOne.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
