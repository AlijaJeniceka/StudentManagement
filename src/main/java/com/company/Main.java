package com.company;

import com.company.controllers.StudentController;
import com.company.login.login;

public class Main {

    public static void main(String[] args) {

        //ternary operator.

     //  System.out.println(StudentController.addNewStudent() ? "Successfully added new student" :
           //     "Failed to add new student");

     //   System.out.println(5 > 7 ? "it's true" : "it's false" );
     //   System.out.println("The student is: " + StudentController.getStudentById().getName());

      // System.out.println((login.addNewUser() ? "Successfully added new user. " : "Failed to add new user. "));
       System.out.println(login.loginIn() ? "Successfully logging in." : "Failed to login. ");

    }
}
//Add a new table to your student database and call it users.
//it should have the following fields: id(INT, AUTO_iNCREMENT), username(varchar(50)), password(varchar(50))
//create a package called login and inside this create a class called login
// and use that class to implement a login and sign up based on
//the users table.
