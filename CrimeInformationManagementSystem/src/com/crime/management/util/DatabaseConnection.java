package com.crime.management.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish the connection
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_db", "root", "root");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
