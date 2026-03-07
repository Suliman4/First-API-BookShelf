package com.books.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/v1")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(path = ("/books"))
    public List<Book> list() {
        return bookService.list();
    }

    @DeleteMapping(path = "/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
        return bookService.deleteBook(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/books")
    public Book add(@RequestBody Book newBook){
       return bookService.add(newBook);
    }

    @GetMapping(path = "/books/{id}")
    public ResponseEntity<Book> find(@PathVariable int id) {
        Book book = bookService.find(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();

    }

    @PutMapping(path = "/books/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book updatedBook){
        Book book = bookService.update(id, updatedBook);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }
}
