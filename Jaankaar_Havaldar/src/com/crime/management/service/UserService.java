package com.crime.management.service;


import com.crime.management.dao.interfaces.UserDAO;
import com.crime.management.model.User;

import java.util.List;
import java.util.Optional;


public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void addUser(User user) {
        try {
            userDAO.addUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error adding user", e);
        }
    }

    public List<User> getAllUsers() {
        try {
            return userDAO.getAllUsers();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all users", e);
        }
    }

    public Optional<User> authenticate(String username, String password) {
        try {
            return userDAO.authenticate(username, password);
        } catch (Exception e) {
            throw new RuntimeException("Error authenticating user", e);
        }
    }

    public User getUserById(int id) {
        try {
            return userDAO.getUserById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user by ID", e);
        }
    }

    public User getUserByUsername(String username) {
        try {
            return userDAO.getUserByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user by username", e);
        }
    }

    public void updateUser(User user) {
        try {
            userDAO.updateUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }
    }

    public void deleteUser(int id) {
        try {
            userDAO.deleteUser(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user", e);
        }
    }
}