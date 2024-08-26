package com.crime.management.service;

import com.crime.management.dao.interfaces.UserDAO;
import com.crime.management.exception.AuthenticationException;
import com.crime.management.exception.UserException;
import com.crime.management.model.User;
import com.crime.management.utils.PasswordHasher;

public class AuthenticationService {
    private final UserDAO userDAO;

    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String username, String password) throws AuthenticationException {
        User user = null;
        try {
            user = userDAO.getUserByUsername(username);
        } catch (UserException e) {
            e.printStackTrace();
           // throw new AuthenticationException("Error in Authenticating login" + e.getMessage());
        }
        if (user == null) {
            throw new AuthenticationException("User not found");
        }
        if (PasswordHasher.verifyPassword(password, user.getPassword())) {
            System.out.println("correct password user is verified");
            return user;
        } else {
            throw new AuthenticationException("Invalid password");
        }
    }

    public void register(User user) throws AuthenticationException {
        String hashedPassword = PasswordHasher.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        try {
            userDAO.addUser(user);
        } catch (UserException e) {
            throw new AuthenticationException("error in registering user" + e.getMessage());
        }
    }
}




