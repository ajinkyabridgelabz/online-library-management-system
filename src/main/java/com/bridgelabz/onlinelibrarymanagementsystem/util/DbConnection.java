package com.bridgelabz.onlinelibrarymanagementsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/online-library-management-system";
        String userName = "root";
        String password = "Tanuja@99";
        Connection connection = null;
        try {
            //load and register the driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established\n");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

}
