# JUnit Testing Exercises

This project contains implementations and explanations for the JUnit Testing Exercises (Exercises 1-4).

---

## Exercise 1: Setting Up JUnit

### Maven Configuration
To set up JUnit in a Java project, we add the JUnit dependency to the `pom.xml` file. The dependency acts as a library manager, downloading the JUnit library and Hamcrest core library for assertions.

Here is the dependency configuration in our [pom.xml](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/JUnit_Testing/pom.xml):
```xml
<dependency> 
    <groupId>junit</groupId> 
    <artifactId>junit</artifactId> 
    <version>4.13.2</version> 
    <scope>test</scope> 
</dependency>
```

### IDE Setup
1. **IntelliJ IDEA**: 
   - Open IntelliJ IDEA and select **Open**.
   - Navigate to the [JUnit_Testing](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/JUnit_Testing/) directory and select the `pom.xml` to import as a Maven project.
   - IntelliJ will automatically resolve the JUnit dependencies.
2. **Eclipse**:
   - Select **File -> Import... -> Existing Maven Projects**.
   - Browse to the project folder and click **Finish**.

---

## Exercise 2: Writing Basic JUnit Tests

We created a simple source class [Calculator.java](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/JUnit_Testing/src/main/java/com/example/Calculator.java) with standard arithmetic operations:
* `add(int a, int b)`
* `subtract(int a, int b)`
* `multiply(int a, int b)`
* `divide(int a, int b)` (includes division by zero validation throwing `IllegalArgumentException`).

We test these basic methods in [CalculatorTest.java](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/JUnit_Testing/src/test/java/com/example/CalculatorTest.java).

---

## Exercise 3: Assertions in JUnit

Assertions are static helper methods in the `org.junit.Assert` class used to determine whether a test case succeeds or fails. 

The test class [AssertionsTest.java](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/JUnit_Testing/src/test/java/com/example/AssertionsTest.java) uses the following assertions:
* **`assertEquals(expected, actual)`**: Checks that two values are equal.
* **`assertTrue(condition)`**: Verifies that a condition is true.
* **`assertFalse(condition)`**: Verifies that a condition is false.
* **`assertNull(object)`**: Verifies that an object reference is null.
* **`assertNotNull(object)`**: Verifies that an object reference is not null.

---

## Exercise 4: Arrange-Act-Assert (AAA) Pattern & Test Fixtures

### The Arrange-Act-Assert (AAA) Pattern
The AAA pattern is a standard structure for writing clean, readable unit tests:
1. **Arrange:** Set up the test requirements, initialize variables, mock dependencies, and construct objects.
2. **Act:** Invoke the method under test.
3. **Assert:** Verify that the action behaves as expected.

Example from [CalculatorTest.java](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/JUnit_Testing/src/test/java/com/example/CalculatorTest.java):
```java
@Test
public void testAdd() {
    // Arrange
    int a = 10;
    int b = 5;

    // Act
    int result = calculator.add(a, b);

    // Assert
    assertEquals(15, result);
}
```

### Test Fixtures: Setup & Teardown
Test fixtures allow us to run setup and cleanup code before and after each test case, ensuring each test runs in a clean, isolated state.
* **`@Before`**: Prepares the environment (e.g., re-initializing class instances, setting up database connections, initializing configurations) before *every* test execution.
* **`@After`**: Cleans up resources (e.g., nullifying objects, closing file streams, closing database connections) after *every* test execution.
