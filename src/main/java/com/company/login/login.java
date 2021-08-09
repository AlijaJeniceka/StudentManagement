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
        System.out.print("Enter username: ");
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
         //   e.printStackTrace();
            System.out.println("Unable to sign up, username probably exist. Try another one.");
            return false;
        }

    }
    public static boolean login() {
        System.out.print("Enter your username: ");
        String username = sc.next().trim();
        System.out.print("Enter your password: ");
        String password = sc.next().trim();

        try {
            ps = dbConnection.getConnection().prepareStatement("SELECT * FROM users WHERE username='" + username + "';");
            rs = ps.executeQuery();

            String passwordCheck = "";
            while (rs.next()) {
                passwordCheck = rs.getString("password");

            }
            System.out.println(passwordCheck);
            return passwordCheck.equals(password);

        } catch (SQLException e) {
            e.printStackTrace();
            //   System.out.println("Unable to login. ");
            return false;
        }
    }


}








