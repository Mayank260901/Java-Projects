package com.crime.management.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Jaankaar_Havaldar";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    private DatabaseConnection() { }

    public static Connection getConnection() throws SQLException {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully.");
            } catch (SQLException e) {
                throw new RuntimeException("Unable to connect to the database."+ e.getMessage());
            }
        }
        return connection;
    }
    public static void closeConnection(){
        if (connection==null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Unable to close database connection");
            }
            System.out.println("Connection is closed");
        }
    }
}
