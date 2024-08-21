package com.crime.management.dao;

import com.crime.management.model.User;

public interface UserDAO {
    User getUserByUsername(String username);
}
