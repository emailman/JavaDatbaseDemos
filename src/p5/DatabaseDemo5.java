package p5;
import java.sql.*;

/* 
 * Author: Eric Mailman
 * File Name: DatabaseDemo5.java
 * Purpose: Connect to a database and delete records from tables
 */

public class DatabaseDemo5 {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:ucanaccess://z:/Database2.accdb");

            System.out.println("Remove all records from tables");

            // Setup an SQL statement
            Statement statement = connection.createStatement();

            // Delete all records from the three tables in the database
            statement.execute("delete * from Enrollment");
            statement.execute("delete * from Students");
            statement.execute("delete * from Courses");

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}