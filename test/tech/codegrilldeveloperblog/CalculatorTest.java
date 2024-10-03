package tech.codegrilldeveloperblog;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in Calculator Class")
class CalculatorTest {
    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method.");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method.");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        System.out.println("Executing @BeforeEach method.");
        calculator = new Calculator();
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executing @AfterEach method.");
    }

    // test<System Under Test>_<Condition or State Change>_<Expected Result>
    @Test
    @DisplayName("Test 6/2 = 3")
    void testIntegerDivision_WhenSixIsDividedByTwo_ShouldReturnThree() {

        System.out.println("Running Test 6/2 = 3");

        // Arrange
        int dividend = 6;
        int divisor = 2;
        int expectedResult = 3;

        // Act
        int result = calculator.integerDivision(dividend, divisor);

        // Assert
        assertEquals(3, result,
                () -> "6/2 did not produce expected result");
    }

    @Test
    @Disabled("TODO: Still need to to work on it")
    @DisplayName("Test division by zero")
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Running Test division by zero");
        fail("Not implemented yet");
    }

    @Test
    @DisplayName("Test 5 - 3 = 2")
    void integerSubtraction() {
        System.out.println("Running Test 5 - 3 = 2");


        // Arrange  // Given
        int minuend = 5;
        int subtrahend = 3;
        int expectedResult = 2;

        // Act  // When
        int result = calculator.integerSubtraction(minuend, subtrahend);

        // Assert   // Then
        assertEquals(expectedResult, result,
                () -> minuend + " - " + subtrahend + " did not produce " + result);
    }
}