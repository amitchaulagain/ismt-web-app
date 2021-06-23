package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Select PreparedStatement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class ManyToManyExample {
    private static final String QUERY = "select c.ClassId as id,c.Title as title,c.Instructor as instructor from class c join ClassStudentRelation r where c.ClassId=r.ClassId and  r.StudentId=?";

    public static void main(String[] args) {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils3.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
           while (rs.next()) {

               String  id = rs.getString("id");
               String title = rs.getString("title");
               String instructor = rs.getString("instructor");


               System.out.println("id " + id);
               System.out.println("title " + title);

               System.out.println("instructor " + instructor);



           }
        } catch (SQLException e) {
        	JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
}
