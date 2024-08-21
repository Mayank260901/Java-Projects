package com.crime.management.service;

import com.crime.management.dao.UserDAO;
import com.crime.management.dao.impl.UserDAOImpl;
import com.crime.management.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOImpl();
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
}
