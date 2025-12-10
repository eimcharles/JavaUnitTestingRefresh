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

}
