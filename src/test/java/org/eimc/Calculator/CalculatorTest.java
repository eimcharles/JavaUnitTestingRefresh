package org.eimc.Calculator;


import org.eimc.calculator.Calculator;
import org.junit.jupiter.api.Test;

// Junit Assertions
import static org.junit.jupiter.api.Assertions.assertEquals;

// AssertJ assertions
import static org.assertj.core.api.Assertions.*;


public class CalculatorTest {


    @Test
    void testUsingJunit_ThatCanAddTwoNumbers(){

        Calculator calculator = new Calculator();
        var result = calculator.add(3,3);

        // Junit Assertion library
        assertEquals(6, result , "The value returned by the add() method can not be negative");

    }

    @Test
    void testUsingAssertJ_ThatCanAddTwoNumbers(){

        Calculator calculator = new Calculator();
        var result = calculator.add(3,3);

        // AssertJ library
        assertThat(result).isEqualTo(6);

    }

}
