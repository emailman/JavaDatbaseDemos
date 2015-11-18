package p6;
import java.sql.*;

/* 
 * Author: Eric Mailman
 * File Name: DatabaseDemo6.java
 * Purpose: Connect to a MySql database and perform a simple query
 */

public class DatabaseDemo6 {

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://music.jigga.tk/db1?user=eric&password=Way2Go");
            System.out.println("Database connection OK");

            // Create a "select" statement
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT `Name` FROM address");

            // Report results
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}