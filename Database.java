package com.aec.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL =
            "jdbc:mysql://localhost:3306/courier_management";

    private static final String USER = "root";

    private static final String PASSWORD = "aloyshia@20may26";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}