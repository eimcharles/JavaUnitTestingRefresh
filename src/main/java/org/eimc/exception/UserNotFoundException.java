package org.eimc.exception;

import java.util.UUID;

/**
 *      UserNotFoundException class
 *      throws a custom exception when a
 *      request is made for a User that
 *      does not exist in the system.
 * */

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID userId) {
        super(String.format("User with ID '%s' not found.", userId));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
