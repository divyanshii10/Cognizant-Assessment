package com.cognizant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    // Test Fixtures - Setup Method
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up test data...");
    }

    // Test Fixtures - Teardown Method
    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("Cleaning up after test...");
    }

    // AAA Pattern: Arrange, Act, Assert
    @Test
    public void testAdd() {
        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result, "10 + 20 should equal 30");
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 10;
        int b = 2;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(5.0, result, "10 / 2 should equal 5.0");
    }

    @Test
    public void testDivideByZero() {
        // Asserting Exceptions
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });

        assertEquals("Division by zero", exception.getMessage());
    }
}
