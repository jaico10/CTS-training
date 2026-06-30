package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    // Setup method runs before each test case
    @Before
    public void setUp() {
        System.out.println("Setting up: Initializing Calculator instance.");
        // Arrange phase for tests (shared fixture setup)
        calculator = new Calculator();
    }

    // Teardown method runs after each test case
    @After
    public void tearDown() {
        System.out.println("Tearing down: Cleaning up Calculator instance.\n");
        calculator = null;
    }

    @Test
    public void testAdd() {
        System.out.println("Running testAdd...");
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        System.out.println("Running testSubtract...");
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        System.out.println("Running testMultiply...");
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(50, result);
    }

    @Test
    public void testDivide() {
        System.out.println("Running testDivide...");
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(2.0, result, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZeroThrowsException() {
        System.out.println("Running testDivideByZeroThrowsException...");
        // Arrange
        int a = 10;
        int b = 0;

        // Act & Assert
        calculator.divide(a, b);
    }
}
