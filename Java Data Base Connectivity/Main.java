package org.example;

import org.sqlite.core.DB;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        User u1 = new User();

        u1.setName("james");
        u1.setSalary(4000);

        User u2 = new User();

        u2.setName("richi");
        u2.setSalary(4564);

        DBManager dbManager = new DBManager("jdbc:sqlite:mydatabase.db");



        try {
            dbManager.initUsersTable();
            System.out.println("insert users");
            //dbManager.insertUser(u1);
            //dbManager.insertUser(u2);

            System.out.println("get all users: ");
            List<User> a = dbManager.getAllUsers();
            System.out.println(a);

            System.out.println("Get all users with salary ABOVE 5000");
            List<User> b = dbManager.getUsersWithSalary(5000,true);
            System.out.println(b);
            System.out.println("Get all users with salary BELOW 5000");
            List<User> c = dbManager.getUsersWithSalary(5000,false);
            System.out.println(c);

            System.out.println("Get user by name \"james\"");
            List<User> d = dbManager.getUserByName("james");
            System.out.println(d);




        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }





    }
}