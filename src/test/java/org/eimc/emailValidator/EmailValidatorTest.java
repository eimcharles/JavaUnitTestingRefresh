package org.eimc.emailValidator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *      Unit testing example 2: EmailValidatorTest
 *
 *      Test methods follow the Arrange-Act-Assert (AAA) pattern,
 *      commonly labeled as Given-When-Then:
 *
 *      1. GIVEN (Arrange): Set up the required inputs, mocks, and expected outcomes.
 *      2. WHEN (Act): Execute the method under test.
 *      3. THEN (Assert): Verify the result using assertions (AssertJ).
 */

class EmailValidatorTest {

    private final EmailValidator emailValidatorTest = new EmailValidator();

    /**
     *          The Disabled annotation prevents the test from running
     *          during the execution of the EmailValidatorTest class.
     *
     *          The EnabledOnOs(OS.WINDOWS) annotation specifies that
     *          if the test was enabled, it would only run on the Windows OS.
     */

    @Test
    @Disabled
    @EnabledOnOs(OS.WINDOWS)
    void canValidateCorrectEmailFormat() {

        // GIVEN
        var testEmail = "c.eimer@me.com";

        // WHEN
        var actualEmail = emailValidatorTest.test(testEmail);

        // THEN - (AssertJ)
        assertThat(actualEmail).isTrue();

    }

    /**
     *          The ParameterizedTest annotation allows to run the same test
     *          multiple times with different sets of input data.
     *
     *          The CsvSource annotation provides the input data to the parameterized
     *          test in a Comma-Separated Values (CSV) format.
     */

    @ParameterizedTest
    @CsvSource(

            {
                    // valid emails based on regex
                    "c.eimer@me.com, true",
                    "john@live.concordia.com, true",

                    // invalid emails based on regex
                    "larry@eimer@me.com, false",
                    "@me.com, false",
                    "'', false",
                    "charles, false",
                    "charles.com, false",
                    "eimer%me.com, false",
                    ".com, false",
            }

    )
    void canValidateAllCorrectEmailFormats(String testEmail, boolean expected) {

        // WHEN
        var actualEmail = emailValidatorTest.test(testEmail);

        // THEN - (AssertJ)
        assertThat(actualEmail).isEqualTo(expected);

    }
}