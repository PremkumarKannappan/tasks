package com.example.manytomanyexample.repository;

import com.example.manytomanyexample.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Books,Long> {
}
