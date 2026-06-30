package com.library.repository;

public class BookRepository {
    public void testRepository() {
        System.out.println("BookRepository method testRepository() invoked successfully.");
    }

    public void save(String bookName) {
        System.out.println("Saving book: '" + bookName + "' to the repository database.");
    }
}
