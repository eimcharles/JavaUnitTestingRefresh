package org.eimc.passwordValidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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
        var testPassword = "  ";

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }

    @Test
    void willFailIfPasswordDoesNotMeetMinimumLengthRequiredAfterTrimming(){

        // GIVEN
        var testPassword = "  pass";

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
        var testPassword = "password";

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
