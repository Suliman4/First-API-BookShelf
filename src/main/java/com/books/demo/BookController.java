package com.books.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class BookController {
    private final List<BookShelf> books = new ArrayList<>();
    @GetMapping(path = ("/books"))
    public List<BookShelf> list(){
        return books;
    }
    @DeleteMapping(path = "/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
        boolean flag = books.removeIf(bookShelf -> bookShelf.getId() == id);
        if (flag){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/books")
    public BookShelf add(@RequestBody BookShelf newBook){
        books.add(newBook);
        return newBook;
    }
    @GetMapping(path = "/books/{id}")
    public BookShelf find(@PathVariable int id) {
        for (BookShelf b : books) {
            if (id == b.getId())
                return b;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The book NOT found");
    }
    @PutMapping(path = "/books/{id}")
    public BookShelf update(@PathVariable int id, @RequestBody BookShelf updatedBook){
        for (BookShelf b : books){
            if (id == b.getId()){
                b.setTitle(updatedBook.getTitle());
                b.setAuthor(updatedBook.getAuthor());
                b.setIsbn(updatedBook.getIsbn());
                b.setPublishedYear(updatedBook.getPublishedYear());
                return b;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The book is NOT FOUND");
    }
}
