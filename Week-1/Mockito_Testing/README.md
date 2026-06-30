# Mockito Testing Exercises

This project contains implementations and explanations for the Mockito Testing Exercises (Exercises 1 & 2) using JUnit 5.

---

## Exercise 1: Mocking and Stubbing

### Concept
* **Mocking:** Creating an simulated (dummy) instance of a dependency (e.g., database service, external REST client, third-party API) that mirrors the class/interface signature but doesn't perform real side effects or actual implementation logic.
* **Stubbing:** Defining predefined values or behaviors to return when specific methods of a mock object are invoked. It allows tests to simulate various scenarios (e.g., successful API responses, network failures, empty results).

In [MyServiceTest.java](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/Mockito_Testing/src/test/java/com/example/MyServiceTest.java):
1. We mock the `ExternalApi` using `Mockito.mock(ExternalApi.class)`.
2. We stub the `getData()` call using `when(mockApi.getData()).thenReturn("Mock Data")`.
3. We assert that when our `MyService` uses this stub, the returned data matches the expected `"Mock Data"`.

---

## Exercise 2: Verifying Interactions

### Concept
* **Verification:** Ensuring that a dependency was indeed called, how many times it was called, and with what parameters. This is highly useful for verifying that code performs expected side-effects (e.g., sending emails, persisting to logs, querying cache) without needing to inspect state values directly.

In [MyServiceTest.java](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/Mockito_Testing/src/test/java/com/example/MyServiceTest.java):
1. We invoke `service.fetchData()`.
2. We check that the underlying api call was executed exactly once using Mockito's `verify()` function: `verify(mockApi).getData()`.

---

## Maven Dependencies

To run Mockito with JUnit 5, we configure the dependencies in [pom.xml](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/Mockito_Testing/pom.xml):
```xml
<!-- JUnit Jupiter API (JUnit 5) -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>

<!-- Mockito Core -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>

<!-- Mockito JUnit Jupiter Integration -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>
```

### How to Run in IDE (IntelliJ / Eclipse)
1. Import this folder as a **Maven project**.
2. Run the test classes in the test runner.
