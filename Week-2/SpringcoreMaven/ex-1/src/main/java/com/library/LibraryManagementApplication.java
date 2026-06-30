package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring Application Context from the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== LibraryManagementApplication (Exercise 1) started ===");

        // Retrieve the BookRepository bean
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookRepository.testRepository();

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.testService();

        System.out.println("=== LibraryManagementApplication (Exercise 1) finished successfully ===\n");
    }
}
