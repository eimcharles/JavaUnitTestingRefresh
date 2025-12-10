package org.eimc.emailValidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class EmailValidatorTest {

    private final EmailValidator emailValidatorTest = new EmailValidator();

    @Test
    void canValidateCorrectEmail() {

        // GIVEN
        var testEmail = "c.eimer@me.com";

        // WHEN
        var actualEmail = emailValidatorTest.test(testEmail);

        // THEN - (AssertJ)
        assertThat(actualEmail).isTrue();

    }

    /**
     *          ParameterizedTest allows to run the same test
     *          multiple times with different sets of input arguments.
     *
     *          CsvSource provides the input data to the parameterized
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
            }

    )
    void canValidateAllCorrectEmails(String testEmail, boolean expected) {

        // WHEN
        var actualEmail = emailValidatorTest.test(testEmail);

        // THEN - (AssertJ)
        assertThat(actualEmail).isEqualTo(expected);

    }
}