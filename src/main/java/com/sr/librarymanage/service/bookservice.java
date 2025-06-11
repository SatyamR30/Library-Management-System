package com.sr.librarymanage.service;



import java.util.List;

import com.sr.librarymanage.model.book;
import com.sr.librarymanage.repository.bookrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bookservice {

    @Autowired
    private bookrepo bookrepo;

    public bookservice(bookrepo bookrepo) {
        this.bookrepo = bookrepo;
    }

    public List<book> getAllbooks() {
        return bookrepo.findAll();
    }

    public book getBookById(Long id) {
        return bookrepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public book addBook(book book) {
        return bookrepo.save(book);
    }

    public List<book> addMultipleBooks(List<book> books) {
        return bookrepo.saveAll(books);
    }

    public book updateBook(Long id, book book) {
        return bookrepo.save(book);
    }

    public void deleteBookById(Long id) {
        bookrepo.deleteById(id);
    }











}