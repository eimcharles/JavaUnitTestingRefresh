package org.eimc.passwordValidator;

import java.util.function.Predicate;

public class PasswordValidator implements Predicate<String> {

    private static final int MIN_PASSWORD_CHAR_LENGTH = 3;
    private static final String CONTAINS_ONE_DIGIT = ".*\\d.*";
    private static final String CONTAINS_SPECIAL_CHAR = ".*[!@#$%^&*()_+=<>?/\\[\\]{}|].*";


    @Override
    public boolean test(String password) {

        if (password == null || password.trim().isBlank()){
            return false;
        }

        password = password.trim();

        if (password.length() < MIN_PASSWORD_CHAR_LENGTH){
            return false;
        }

        // Must contain at least one digit
        if (!password.matches(CONTAINS_ONE_DIGIT)){
            return false;
        }

        // Must contain at least special character
        if (!password.matches(CONTAINS_SPECIAL_CHAR)){
            return false;
        }

        return true;
    }
}
