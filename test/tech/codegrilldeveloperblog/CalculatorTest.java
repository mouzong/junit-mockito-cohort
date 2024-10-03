package tech.codegrilldeveloperblog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
//    @Disabled("TODO: Still need to to work on it")
    @DisplayName("Test division by zero")
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Running Test division by zero");
//        fail("Not implemented yet");
        // Arrange
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        // Act & Assert
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(dividend, divisor);

        }, "Division by zero should have thrown an Arithmetic exception");

        // Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }

    @DisplayName("Test Integer subtraction [minuend, subtrahend, expectedResult]")
    @ParameterizedTest
//    @MethodSource()
//    @CsvSource({
//            "33, 1, 32",
//            "24, 1, 23",
//            "58, 52, 6",
//            "12, 4, 8",
//            "33, 23, 10",
//            "7, 3, 4",
//    })
    @CsvSource({
            "apple, orange",
            "apple, strawberry",
            "apple, ''",
            "apple, ",
    })
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {

        System.out.println("Running Test " + minuend + " - " + subtrahend + " = " + expectedResult);

        // Act  // When
        int result = calculator.integerSubtraction(minuend, subtrahend);

        // Assert   // Then
        assertEquals(expectedResult, result,
                () -> minuend + " - " + subtrahend + " did not produce " + result);
    }

//    private static Stream<Arguments> integerSubtraction() {
//        return Stream.of(
//                Arguments.of(5, 3, 2),
//                Arguments.of(54, 1, 53),
//                Arguments.of(24, 6, 18)
//        );
//    }
}