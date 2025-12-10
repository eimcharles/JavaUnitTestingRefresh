package org.eimc.passwordValidator;

import java.util.function.Predicate;

public class PasswordValidator implements Predicate<String> {

    @Override
    public boolean test(String password) {

        if (password == null){
            return false;
        }

        return true;
    }
}
