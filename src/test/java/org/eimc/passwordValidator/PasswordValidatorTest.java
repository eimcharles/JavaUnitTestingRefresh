package org.eimc.passwordValidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *      Unit testing example 3: PasswordValidatorTest
 *
 *      Test methods follow the Arrange-Act-Assert (AAA) pattern,
 *      commonly labeled as Given-When-Then:
 *
 *      1. GIVEN (Arrange): Set up the required inputs, mocks, and expected outcomes.
 *      2. WHEN (Act): Execute the method under test.
 *      3. THEN (Assert): Verify the result using assertions (AssertJ).
 */

public class PasswordValidatorTest {

    private final PasswordValidator passwordValidatorTest = new PasswordValidator();

    @Test
    void willFailIfPasswordIsNull(){

        // GIVEN
        String testPassword = null;

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }

    @Test
    void willFailIfPasswordIsEmpty(){

        // GIVEN
        var testPassword = "";

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }

    @Test
    void willFailIfPasswordContainsEmptySpaces(){

        // GIVEN
        var testPassword = "   ";

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }

    @Test
    void willFailIfPasswordDoesNotMeetMinimumLengthRequiredAfterTrimming(){

        // GIVEN
        var testPassword = "  pa";

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }

    @Test
    void willFailIfPasswordDoesNotContainAtLeastOneDigit(){

        // GIVEN
        var testPassword = "password";

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }

    @Test
    void willFailIfPasswordDoesNotContainAtLeastOneSpecialCharacter(){

        // GIVEN
        var testPassword = "password1";

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }

    @ParameterizedTest
    @CsvSource(

            {
                    // GIVEN
                    "pas, false",
                    "@, false",
                    "3, false",
                    "password!, false",
                    "password, false",

                    "password1!, true",
                    "5password@, true",
                    "pass4word&, true",
            }
    )
    void canValidateRequiredPasswordCharacters(String testPassword, boolean expected){

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isEqualTo(expected);
    }

}
