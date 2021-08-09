package com.company.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.company.dbhelper.dbConnection;
import com.company.objects.Student;

public class StudentController {

    //Initialize the scanner
   private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewStudent() {
        //Promplt the user for data
        System.out.print("Enter the name of the student: ");
        String name = sc.next();

        System.out.print("Enter the age of the student: ");
        int age = sc.nextInt();



      try {
          // Inserts students to the table.
          ps = dbConnection.getConnection().prepareStatement("INSERT INTO students(name, age)"
              + " VALUES(' " + name + "'," + age + ")");

          ps.execute();
          return true;
      } catch(SQLException e) {
          e.printStackTrace();
          return false;
      }

    }
        public static Student getStudentById() {

            //Prompt the user to enter the id of the student they want to retrieve

            System.out.print("Enter the id of the student: ");
            int id = sc.nextInt();

            try {
                ps = dbConnection.getConnection().prepareStatement("SELECT * FROM students WHERE id=" + id);
                rs = ps.executeQuery();

                int studentId, age;
                String name;

                Student student = new Student();
                while(rs.next()){
                    studentId = rs.getInt("id");
                    name = rs.getString("name");
                    age = rs.getInt("age");
                    student.setId(studentId);
                    student.setName(name);
                    student.setAge(age);


                }
                return student;



            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }

        }
    public static void addStudentScores() {

        //Prompt the user for data
        System.out.print("Enter the students id: ");
        int id = sc.nextInt();

        System.out.print("Enter the mathematics score of the student: ");
        int mathSc = sc.nextInt();
        System.out.print("Enter the English score of the student: ");
        int engSc = sc.nextInt();



        try {
            // Inserts students to the table.
            ps = dbConnection.getConnection().prepareStatement("INSERT INTO scores (Mathematics, English, student_id)"
                    + " VALUES(" + mathSc + ", " + engSc + ", " + id + ")");

            ps.execute();
            System.out.println("Successfully added score. ");
        } catch(SQLException e) {
            e.printStackTrace();

        }

    }
    public static void editScores() {

        //Prompt the user for data
        System.out.print("Enter the students id: ");
        int id = sc.nextInt();

        System.out.print("Enter the new mathematics score of the student: ");
        int mathSc = sc.nextInt();
        System.out.print("Enter the new English score of the student: ");
        int engSc = sc.nextInt();

        try {
            // Inserts students to the table.
            ps = dbConnection.getConnection().prepareStatement("UPDATE scores WHERE id="+ id);

            ps.execute();
            System.out.println("Successfully edited score. ");
        } catch(SQLException e) {
            e.printStackTrace();

        }

    }
    public static void editStudent() {

        //Prompt the user for data
        System.out.print("Enter the students id: ");
        int id = sc.nextInt();

        System.out.print("Enter the new name of the student: ");
        String name= sc.next();
        System.out.print("Enter the new age of the student: ");
        int age = sc.nextInt();


        try {
            // Inserts students to the table.
            ps = dbConnection.getConnection().prepareStatement("UPDATE students WHERE id="+ id);

            ps.execute();
            System.out.println("Successfully edited score. ");
        } catch(SQLException e) {
            e.printStackTrace();

        }

    }
    public static void deleteStudentScores() {

        //Prompt the user for data
        System.out.print("Enter the students id you want to delete scores: ");
        int id = sc.nextInt();


        try {
            // Inserts students to the table.
            ps = dbConnection.getConnection().prepareStatement("DELETE FROM scores WHERE id="+ id);

            ps.execute();
            System.out.println("Successfully deleted. ");
        } catch(SQLException e) {
            e.printStackTrace();

        }

    }
    public static void deleteStudent() {

        //Prompt the user for data
        System.out.print("Enter the students id you want to delete: ");
        int id = sc.nextInt();


        try {
            // Inserts students to the table.
            ps = dbConnection.getConnection().prepareStatement("DELETE FROM students WHERE id="+ id);

            ps.execute();
            System.out.println("Successfully deleted. ");
        } catch(SQLException e) {
            e.printStackTrace();

        }

    }
}


//Add methods to remove a student's score, edit a student's score and remove a student and edit student's details.
// 4 methods.
