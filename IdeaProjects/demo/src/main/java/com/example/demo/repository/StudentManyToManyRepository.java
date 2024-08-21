package com.example.demo.repository;

import com.example.demo.entity.ManyToMany.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentManyToManyRepository extends JpaRepository<Student,Long>
{
}
