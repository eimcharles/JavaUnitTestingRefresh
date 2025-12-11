package org.eimc.emailValidator;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 *      Example 2: EmailValidator
 * */

public class EmailValidator implements Predicate<String> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    /**
     *      Checks if the email is non-null
     *      and matches the required email regex pattern.
     */

    @Override
    public boolean test(String email) {
        return email != null
                && EMAIL_PATTERN.matcher(email).matches();
    }

}
