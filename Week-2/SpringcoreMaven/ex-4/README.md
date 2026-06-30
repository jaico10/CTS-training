# Exercise 4: Creating and Configuring a Maven Project

This project demonstrates the creation and configuration of a Maven project with dependencies for Spring Context, Spring AOP, and Spring WebMVC, along with configuring the compiler plugin targeting Java 1.8.

---

## Configuration Details

### 1. Maven Project Properties
The Project Object Model (POM) configuration file [pom.xml](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-2/SpringcoreMaven/ex-4/pom.xml) defines coordinates:
* `groupId`: `com.library`
* `artifactId`: `LibraryManagement`
* `version`: `1.0-SNAPSHOT`

---

### 2. Spring Dependencies Added
We included the following dependencies in the POM:
* **Spring Context (`spring-context`):** Provides the core Spring container, supporting Dependency Injection, Inversion of Control (IoC), Lifecycle events, and Resource loading.
* **Spring AOP (`spring-aop`):** Provides Aspect-Oriented Programming support to implement cross-cutting concerns (such as logging, transaction management, or security validation) modularly.
* **Spring WebMVC (`spring-webmvc`):** Provides the Model-View-Controller framework for creating web applications, REST services, and controllers.

---

### 3. Maven Compiler Plugin
To ensure compatibility across developer machines and runtimes, the Maven Compiler Plugin is configured to compile the source code using **Java 1.8** and produce bytecode targeting **Java 1.8**:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
    </configuration>
</plugin>
```
This forces the build environment to use the strict specifications of Java 8 during build time.
