package com.jdbcconnectivity.LibraryManagement.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/library_management_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";        // change if needed
    private static final String PASSWORD = "Harsh@123";   // change if needed

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Database Connection Failed", e);
        }
    }
}
