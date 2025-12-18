package org.eimc.user.dao;

import org.eimc.exception.UserNotFoundException;
import org.eimc.user.User;

import java.util.Arrays;
import java.util.UUID;

/**
 *      ArrayUserDAO is a Data Access Object (DAO)
 *      class for managing User objects,
 *      it implements the UserDAO contract.
 *
 *      This implementation stores and manages users using arrays.
 */

public class ArrayUserDAO implements UserDAO {

    private final User[] userDAO;
    private int numberOfUsers = 0;
    private static final int MAX_CAPACITY_OF_USERS = 2;

    public ArrayUserDAO() {

        this.userDAO = new User[MAX_CAPACITY_OF_USERS];

        addUser(new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                "Charles",
                "Eimer"));

        addUser(new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"),
                "Jerry",
                "LeBlond"));
    }

    @Override
    public  User[] getUsers() {
        // Copy of User objects returned from userDAO
        return Arrays.copyOf(this.userDAO, this.userDAO.length);
    }
    
    @Override
    public void addUser(User user) {

        if (this.numberOfUsers >= this.userDAO.length) {
            throw new IllegalStateException(String.format("No more available space to add users"));
        }

        this.userDAO[this.numberOfUsers] = user;
        this.numberOfUsers++;
    }

    @Override
    public User getUserById(UUID id) {

        for (User user : getUsers()) {
            if (user != null && user.getUserId().equals(id)) {
                return user;
            }
        }

        // User not found
        throw new UserNotFoundException(id);

    }
}
