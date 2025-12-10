package org.eimc.passwordValidator;

import java.util.function.Predicate;

public class PasswordValidator implements Predicate<String> {

    public static final int MIN_PASSWORD_CHAR_LENGTH = 3;

    @Override
    public boolean test(String password) {

        if (password == null || password.trim().isBlank()){
            return false;
        }

        password = password.trim();

        if (password.length() < MIN_PASSWORD_CHAR_LENGTH){
            return false;
        }

        return true;
    }
}
