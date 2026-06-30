package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookService setter setBookRepository() called: Injection complete.");
        this.bookRepository = bookRepository;
    }

    public void testService() {
        System.out.println("BookService method testService() invoked successfully.");
    }

    public void addBook(String bookName) {
        System.out.println("BookService: Delegating addBook to BookRepository...");
        bookRepository.save(bookName);
    }
}
