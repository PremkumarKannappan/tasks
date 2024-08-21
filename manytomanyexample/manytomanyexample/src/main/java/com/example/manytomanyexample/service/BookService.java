package com.example.manytomanyexample.service;

import com.example.manytomanyexample.entity.Student;
import com.example.manytomanyexample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.manytomanyexample.entity.Books;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Books findById(Long id)
    {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Books> findAll ()
    {
        return bookRepository.findAll();
    }

    public Books addBook(Books book)
    {
        return bookRepository.save(book);
    }

}
