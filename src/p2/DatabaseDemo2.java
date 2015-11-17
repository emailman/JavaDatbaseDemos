package p2;
import java.sql.*;

/* 
 * Author: Eric Mailman
 * File Name: DatabaseDemo2.java
 * Purpose: Connect to a database and load tables with values
 */

public class DatabaseDemo2 {

    public static void main(String[] args) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:ucanaccess://z:/Database2.accdb");
            System.out.println("Load Students and Courses Tables");

            // Setup an SQL statement
            Statement statement = connection.createStatement();

            // Insert three records into the Students table
            statement.execute("INSERT INTO "
                    + "Students (StudentID, StudentName, Major, Department) "
                    + "VALUES (700123456, 'John Jones', 'CT', 'CSC')");
            statement.execute("INSERT INTO "
                    + "Students (StudentID, StudentName, Major, Department) "
                    + "VALUES (700123457, 'Jim Jones', 'CT', 'CIS')");
            statement.execute("INSERT INTO "
                    + "Students (StudentID, StudentName, Major, Department) "
                    + "VALUES (700123458, 'Jane Jones', 'CT', 'CNE')");

            // Insert three records into the Courses table
            statement.execute("INSERT INTO "
                    + "Courses (CRN, CourseName, Major, CourseNumber, Section) "
                    + "VALUES (11594, 'Intro to Programming', 'CIS', 120, '401')");
            statement.execute("INSERT INTO "
                    + "Courses (CRN, CourseName, Major, CourseNumber, Section) "
                    + "VALUES (18281, 'Intro to Programming', 'CIS', 120, '4L3')");
            statement.execute("INSERT INTO "
                    + "Courses (CRN, CourseName, Major, CourseNumber, Section) "
                    + "VALUES (17451, 'Computer Science 1  ', 'CSC', 114, '401')");

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}