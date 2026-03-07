package com.books.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class BookService {
        private final List<Book> books = new ArrayList<>();
        public List<Book> list(){
            return books;
        }

        public boolean deleteBook(int id){
           boolean flag = books.removeIf(book -> book.getId() == id);
           return flag;
        }

        public Book add(Book newBook){
            books.add(newBook);
            return newBook;
        }

        public Book find(int id) {
            for (Book b : books) {
                if (id == b.getId())
                    return b;
            }
            return null;
        }

        public Book update(int id, Book updatedBook){
            for (Book book : books){
                if (id == book.getId()){
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setIsbn(updatedBook.getIsbn());
                    book.setPublishedYear(updatedBook.getPublishedYear());
                    return book;
                }
            }
            return null;
        }

}

