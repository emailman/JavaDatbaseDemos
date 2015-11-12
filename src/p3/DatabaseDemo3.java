package p3;
import java.sql.*;

/* 
 * Author: Eric Mailman
 * File Name: DatabaseDemo3.java
 * Purpose: Connect to a database and a load table with values
 */

public class DatabaseDemo3 {

    public static void main(String[] args) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:ucanaccess://z:/Database2.accdb");

            System.out.println("Load Enrollment Table");

            // Setup an SQL statement
            Statement statement = connection.createStatement();

            // Insert four records into the Enrollment table
            statement.execute
                    ("insert into Enrollment (CRN, StudentID) "
                            + "values (17451, 700123456)");
            statement.execute
                    ("insert into Enrollment (CRN, StudentID) "
                            + "values (17451, 700123457)");
            statement.execute
                    ("insert into Enrollment (CRN, StudentID) "
                            + "values (11594, 700123458)");
            statement.execute
                    ("insert into Enrollment (CRN, StudentID) "
                            + "values (11594, 700123456)");

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}