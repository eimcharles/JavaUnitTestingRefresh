package org.eimc.passwordValidator;

import org.junit.jupiter.api.Test;

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
        String testPassword = "  ";

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }

    @Test
    void willFailIfPasswordDoesNotMeetMinimumLengthRequiredAfterTrimming(){

        // GIVEN
        String testPassword = "  pass";

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }

    @Test
    void willFailIfPasswordDoesNotContainAtLeastOneDigit(){

        // GIVEN
        String testPassword = "password";

        // WHEN
        var actualPassword = passwordValidatorTest.test(testPassword);

        // THEN
        assertThat(actualPassword).isFalse();
    }


}
