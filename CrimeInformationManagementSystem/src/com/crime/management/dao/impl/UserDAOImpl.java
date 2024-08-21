package com.crime.management.dao.impl;

import com.crime.management.dao.UserDAO;
import com.crime.management.model.User;
import com.crime.management.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private Connection conn;

    public UserDAOImpl() {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving user from the database: " + e.getMessage());
            e.printStackTrace();
        }
        return user;
    }
}
