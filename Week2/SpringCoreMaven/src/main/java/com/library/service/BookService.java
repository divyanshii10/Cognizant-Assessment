package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("BookService managing books...");
        if (bookRepository != null) {
            bookRepository.getBooks();
        } else {
            System.out.println("BookRepository is not injected!");
        }
    }
}
