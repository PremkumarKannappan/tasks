package com.example.demo.service;

import com.example.demo.entity.ManyToMany.Library;
import com.example.demo.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    LibraryRepository libraryRepository;

    public Library addLibrary(Library library)
    {
       return libraryRepository.save(library);
    }
}
