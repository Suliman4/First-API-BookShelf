package com.books.demo;

public class BookShelf {
    private static int bookNum= 0;
    private int id;
    private String title;
    private String author;
    private String isbn;
    private String publishedYear;

    public BookShelf(String title, String author, String isbn, String publishedYear) {
        bookNum++;
        this.id = bookNum;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
