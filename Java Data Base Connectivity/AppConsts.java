package org.example;

public class AppConsts
{

    public final static String SQLITE_CREATE =
            "CREATE TABLE IF NOT EXISTS users ("
            + "	id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "	name text ,"
            + "	salary REAL"
            + ");";

    public final static String MYSQL_CREATE =
            "CREATE TABLE IF NOT EXISTS users ("
                    + " id INT AUTO_INCREMENT PRIMARY KEY,"
                    + " name VARCHAR(255),"
                    + " salary DECIMAL(10, 2)"
                    + ");";

}
