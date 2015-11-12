package p1;
import java.sql.*;

/* 
 * Author: Eric Mailman
 * File Name: DatabaseDemo1.java
 * Purpose: Connect to a database and perform a simple query
 */

public class DatabaseDemo1 {

    public static void main(String[] args) throws SQLException {

        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:ucanaccess://z:/Database1.accdb");

            // Create a "select" statement
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT [LastName] FROM [Clients]");

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