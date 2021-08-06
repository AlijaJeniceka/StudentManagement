package com.company.dbhelper;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class dbConnection {

    public static Connection getConnection() {
        Connection connection = null;


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", User.USERNAME.getValue(),
                    User.PASSWORD.getValue());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
