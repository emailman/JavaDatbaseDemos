package p6;
import java.sql.*;

/* 
 * Author: Eric Mailman
 * File Name: DatabaseDemo6.java
 * Purpose: Connect to a MySql database and perform a simple query
 */

public class DatabaseDemo6 {

    public static void main(String[] args) throws SQLException {

        // Strings used for connecting to database
        String url =
                "jdbc:mysql:" +
                        "//phpmyadmin.cdgwdgkn5fuv." +
                        "us-west-2.rds.amazonaws.com:3306/eric_db";
        String user = "db_eric";
        String password = "Way2Go";

        url =
                "jdbc:mysql:" +
                        "//phpmyadmin.cdgwdgkn5fuv." +
                        "us-west-2.rds.amazonaws.com:3306/cis282_project";
        user = "drew";
        password = "dr2949";

        try {
            /* This needs to be included in the External Libraries:
             * mysql-connector-java-5.1.38-bin.jar
             * for the following statement to work
             */
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            Connection connection =
                    DriverManager.getConnection(url, user, password);
            System.out.println("Database connection OK");

            // Create a "select" statement
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM EMPLOYEE");

            // Report results
            while (rs.next()) {
                System.out.println
                        (rs.getString(2) + " " +
                                rs.getString(3));
            }

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}