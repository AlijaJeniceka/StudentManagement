package com.company.login;

import com.company.dbhelper.dbConnection;
import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;

public class login {
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    public static boolean addNewUser() {
        //Prompt the user for data
        System.out.print("Enter login: ");
        String login = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();


        try {
            // Inserts users to the table.
            ps = dbConnection.getConnection().prepareStatement("INSERT INTO users(username, password)"
                    + " VALUES(' " + login + "','" + password + "')");

            ps.execute();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean loginIn() {
        System.out.print("Enter your username to login: ");
        String login = sc.next();

        try {
            ps = dbConnection.getConnection().prepareStatement("SELECT * FROM users WHERE username=" + login);
            rs = ps.executeQuery();

            int id;
            String username, password;

            while (rs.next()){

                    id = rs.getInt("id");
                    username = rs.getString("username");
                    password = rs.getString("password");

                }

           return true;



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

}






