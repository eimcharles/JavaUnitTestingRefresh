package org.eimc.Calculator;


import org.eimc.calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Junit Assertions
import static org.junit.jupiter.api.Assertions.assertEquals;

// AssertJ assertions
import static org.assertj.core.api.Assertions.*;

/**
 *      Test methods follow the Arrange-Act-Assert (AAA) pattern,
 *      commonly labeled as Given-When-Then:
 *
 *      1. GIVEN (Arrange): Set up the required inputs, mocks, and expected outcomes.
 *      2. WHEN (Act): Execute the method under test..
 *      3. THEN (Assert): Verify the result using assertions (JUnit or AssertJ).
 */

public class CalculatorTest {

    private Calculator calculatorUnderTest;

    @BeforeEach
    void setUp() {
        calculatorUnderTest = new Calculator();
    }

    @Test
    void testUsingJunit_ThatCanAddTwoNumbers(){

        // 1 - GIVEN
        var number1 = 3;
        var number2 = 3;
        var expectedResult = 6;

        // 2 - WHEN
        var actualResult = calculatorUnderTest.add(number1,number2);

        // 3 - THEN (Junit)
        assertEquals(expectedResult, actualResult , "The value returned by the add() method can not be negative");

    }

    @Test
    void testUsingAssertJ_ThatCanAddTwoNumbers(){

        // 1 - GIVEN
        var number1 = 3;
        var number2 = 3;
        var expectedResult = 6;

        // 2 - WHEN
        var actualResult = calculatorUnderTest.add(number1,number2);

        // 3 - THEN (AssertJ)
        assertThat(actualResult).isEqualTo(expectedResult);

    }

}
