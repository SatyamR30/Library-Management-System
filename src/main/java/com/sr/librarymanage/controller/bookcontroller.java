package com.sr.librarymanage.controller;


import com.sr.librarymanage.model.book;
import com.sr.librarymanage.service.bookservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class bookcontroller {

    @Autowired
    private bookservice bookservice;


    public bookcontroller(bookservice bookservice) {
        this.bookservice = bookservice;
    }

    @GetMapping
    public List<book> getAllBooks() {
        return bookservice.getAllbooks();
    }

    @GetMapping("/{id}")
    public book getBookById(@PathVariable Long id) {
        return bookservice.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public book addBook( @Valid @RequestBody book book) {
        return bookservice.addBook(book);
    }

    @PostMapping("/bulk")
    public List<book> createMultipleBooks(@RequestBody List<book> books) {
        return bookservice.addMultipleBooks(books);
    }


    @PutMapping("/{id}")
    public book updateBook(@PathVariable Long id, @RequestBody book book) {
        book.setId(id);
        return  bookservice.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookservice.deleteBookById(id);
    }


}
