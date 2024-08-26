package com.crime.management.dao.implementations;

import com.crime.management.dao.interfaces.UserDAO;
import com.crime.management.db.DatabaseConnection;
import com.crime.management.db.Queries;
import com.crime.management.exception.UserException;
import com.crime.management.model.Enums.Role;
import com.crime.management.model.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private final Connection conn;
    public UserDAOImpl() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method 1

    @Override
    public void addUser(User user) throws UserException {
        try (PreparedStatement statement = conn.prepareStatement(Queries.ADD_USER)){
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole().toString());
            statement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UserException("Error in Adding new user " + e.getMessage());

        }
    }

    @Override
    public List<User> getAllUsers() throws UserException {
        List<User> users = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(Queries.GET_ALL_USERS);
            while (rs.next()) {
                Timestamp lastLoginTimestamp = rs.getTimestamp("lastLogin");
                LocalDateTime lastLogin = (lastLoginTimestamp != null) ? lastLoginTimestamp.toLocalDateTime() : LocalDateTime.now();
                users.add(new User(

                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role")),
                        lastLogin
                ));
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new UserException("Error in getting all Users in user DAO Implementation " + e.getMessage());
        }
        return users;
    }

    // Method 2

    @Override
    public Optional<User> authenticate(String username, String password) {
        try (PreparedStatement statement = conn.prepareStatement(Queries.AUTHENTICATE_USER)) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new User(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            Role.valueOf(resultSet.getString("role")),
                            resultSet.getTimestamp("lastLogin").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // Method 3

    @Override
    public User getUserByUsername(String username)  throws UserException {
        try (
             PreparedStatement statement = conn.prepareStatement(Queries.GET_USER_BY_USERNAME)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    /* return (new User(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            Role.valueOf(resultSet.getString("role")),
                            resultSet.getTimestamp("last_login").toLocalDateTime()
                            ));
                     */
                    Timestamp lastLoginTimestamp = resultSet.getTimestamp("lastLogin");

                    // Convert to LocalDateTime, or use LocalDateTime.now() if lastLoginTimestamp is null
                    LocalDateTime lastLogin = (lastLoginTimestamp != null) ? lastLoginTimestamp.toLocalDateTime() : LocalDateTime.now();

                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            Role.valueOf(resultSet.getString("role")),
                            lastLogin
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException(" Error retrieving all user  " + e.getMessage());
        }
        return null;
    }

    @Override
    public User getUserById(int id) throws UserException {
        User user = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(Queries.GET_USER_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role")),
                        rs.getTimestamp("lastLogin").toLocalDateTime()

                );
            }
        } catch (SQLException e) {
            //e.printStackTrace();
           throw new UserException(" Error in getting user by Id " + e.getMessage());
        }
        return user;
    }


    @Override
    public void updateUser(User user) throws UserException {
        try {PreparedStatement stmt = conn.prepareStatement(Queries.UPDATE_USER);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole().name());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
           // e.printStackTrace();
            throw new UserException(" Error in updating user" + e.getMessage());
        }
    }

    @Override
    public void deleteUser(int id) {
        try {PreparedStatement stmt = conn.prepareStatement(Queries.DELETE_USER);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly
        }
    }
}