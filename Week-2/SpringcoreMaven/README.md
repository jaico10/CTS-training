# Spring Core Maven Exercises

This repository contains implementations of Spring Core setup and Dependency Injection exercises in a Maven project structure.

---

## Core Concepts

### 1. Inversion of Control (IoC)
**Inversion of Control (IoC)** is a design principle in software engineering by which the control of object creation, configuration, and lifecycle management is transferred from the application program code to a container or framework (in this case, the **Spring Container**). Instead of classes instantiating their own dependencies, the container instantiates them and supplies them to the classes when needed.

### 2. Dependency Injection (DI)
**Dependency Injection (DI)** is a pattern that implements IoC. It is the process of supplying a resource (dependency) that a class needs to function.
In Spring, there are two primary methods of Dependency Injection:
* **Constructor Injection:** Dependencies are provided through a class constructor.
* **Setter Injection:** Dependencies are provided through setter methods.

---

## Exercises Implemented

### Exercise 1: Configuring a Basic Spring Application
Located in: [Week-2/SpringcoreMaven/ex-1/](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-1/)

* **Beans Configured:** [BookRepository](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-1/src/main/java/com/library/repository/BookRepository.java) and [BookService](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-1/src/main/java/com/library/service/BookService.java) are defined as separate, independent beans.
* **XML Configuration:** Defined in [applicationContext.xml](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-1/src/main/resources/applicationContext.xml).
* **Main Class:** [LibraryManagementApplication](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-1/src/main/java/com/library/LibraryManagementApplication.java) loads the context and instantiates both beans independently.

### Exercise 2: Implementing Dependency Injection (Setter Injection)
Located in: [Week-2/SpringcoreMaven/ex-2/](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-2/)

* **Beans Configured:** [BookRepository](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-2/src/main/java/com/library/repository/BookRepository.java) is wired as a dependency inside [BookService](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-2/src/main/java/com/library/service/BookService.java).
* **Setter Injection Method:**
  ```java
  public void setBookRepository(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
  }
  ```
* **XML Configuration (Wiring):** Defined in [applicationContext.xml](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-2/src/main/resources/applicationContext.xml) using the `<property>` tag.
* **Main Class:** [LibraryManagementApplication](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-2/src/main/java/com/library/LibraryManagementApplication.java) retrieves `BookService` and invokes `addBook()`, verifying that `BookRepository` was injected successfully.

### Exercise 4: Creating and Configuring a Maven Project
Located in: [Week-2/SpringcoreMaven/ex-4/](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-4/)

* **Maven POM Structure:** Configured in [pom.xml](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-4/pom.xml).
* **Dependencies Configured:** Configures Spring Context, Spring AOP, and Spring WebMVC dependencies.
* **Compiler Configuration:** Configures the `maven-compiler-plugin` targeting Java version `1.8` for strict code compatibility.
