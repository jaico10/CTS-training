package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring Application Context from the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== LibraryManagementApplication (Exercise 2) started ===");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.testService();

        // Verify successful dependency injection by adding a book
        bookService.addBook("Design Patterns: Elements of Reusable Object-Oriented Software");

        System.out.println("=== LibraryManagementApplication (Exercise 2) finished successfully ===\n");
    }
}
