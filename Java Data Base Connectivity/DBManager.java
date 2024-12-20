package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private String dbUrl;


    public DBManager(String dbUrl) {
        this.dbUrl = dbUrl;

    }

    public DBManager(String dbUrl,String userName, String password) {
        this.dbUrl = dbUrl;
    }
    public void initUsersTable() throws SQLException {
        String sqlCreate = AppConsts.SQLITE_CREATE;
        try(Connection connection = DriverManager.getConnection(dbUrl);

            Statement statement = connection.createStatement())
        {
            statement.execute(sqlCreate);
        }

    }

    public void insertUser(User u) throws SQLException {
        String sqlInsert = "INSERT INTO users(name,salary) VALUES(?,?)";
        try(Connection connection = DriverManager.getConnection(dbUrl);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert))
        {
            preparedStatement.setString(1,u.getName());
            preparedStatement.setDouble(2,u.getSalary());
            preparedStatement.executeUpdate();

        }

    }

    public List<User> getAllUsers() throws SQLException {

        List<User> arr = new ArrayList<>();
        String sqlSelect = "SELECT * FROM users";
        try(Connection connection = DriverManager.getConnection(dbUrl);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect)
            )
        {
            while(rs.next())
            {
                // ROW - MAP to User Object
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setSalary(rs.getDouble("salary"));

                arr.add(u);
            }

            return arr;

        }
    }

    public List<User> getUsersWithSalary(int salary,boolean above) throws SQLException {

        List<User> arr = new ArrayList<>();
        String sqlSelect;
        if (above)
        {
            sqlSelect = "SELECT * FROM users WHERE salary > " +salary;
        }
        else
        {
            sqlSelect = "SELECT * FROM users WHERE salary < " +salary;
        }
        try(Connection connection = DriverManager.getConnection(dbUrl);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect)
        )
        {
            while(rs.next())
            {
                // ROW - MAP to User Object
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setSalary(rs.getDouble("salary"));


                arr.add(u);
            }

            return arr;

        }




    }

    public List<User> getUserByName(String name) throws SQLException {

        List<User> arr = new ArrayList<>();
        String sqlSelect = "SELECT * FROM users WHERE name = '"+name+"'";
        try(Connection connection = DriverManager.getConnection(dbUrl);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect)
        )
        {
            while(rs.next())
            {
                // ROW - MAP to User Object
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setSalary(rs.getDouble("salary"));

                arr.add(u);
            }

            return arr;

        }
    }





}
