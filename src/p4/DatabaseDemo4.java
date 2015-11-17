package p4;
import java.sql.*;

/* 
 * Author: Eric Mailman
 * File Name: DatabaseDemo4.java
 * Purpose: Connect to a database and perform a query
 */

public class DatabaseDemo4 {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:ucanaccess://z:/Database2.accdb");
            System.out.println("Report on Student Enrollment");

            // Setup an SQL statement
            Statement statement = connection.createStatement();

            // Perform a query using a "select" statement
            ResultSet resultSet = statement.executeQuery
                    ("SELECT" +
                            " Students.[StudentName]," +
                            " Students.[StudentID]," +
                            " Courses.[CourseName]," +
                            " Courses.[Major]," +
                            " Courses.[CourseNumber]," +
                            " Courses.[Section]" +
                            " FROM Courses, Students, Enrollment" +
                            " WHERE Enrollment.[StudentID] = Students.[StudentID]" +
                            " AND Enrollment.CRN=Courses.CRN" +
                            " ORDER BY Students.[StudentName], Courses.[CourseName]");

            // Loop through the result set
            int i = 0;
            while (resultSet.next()) {
                i++;
                System.out.println("Student: " + resultSet.getString(1) +
                        "\t\tStudent ID: " + resultSet.getString(2) +
                        "\t\tCourse: " + resultSet.getString(3) +
                        "\t\tClass: " + resultSet.getString(4) + " " +
                        resultSet.getString(5) + "-" +
                        resultSet.getString(6));
            }

            System.out.println("\nRecord count = " + i + "\n");

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}