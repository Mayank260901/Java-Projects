package com.crime.management.dao.interfaces;

import com.crime.management.exception.UserException;
import com.crime.management.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    void addUser(User user) throws UserException;
    List<User> getAllUsers() throws UserException;
    Optional<User> authenticate(String username, String password) throws UserException;
    User getUserById(int id) throws UserException;
    User getUserByUsername(String username)  throws UserException;
    void updateUser(User user) throws UserException ;
    void deleteUser(int id) throws UserException;

}
