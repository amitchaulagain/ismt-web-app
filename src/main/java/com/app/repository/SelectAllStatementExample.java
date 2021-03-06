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
public class SelectAllStatementExample {
    private static final String QUERY = "SELECT p.created_at, op.created_at as hero   FROM products p join ordered_product op ";

    public static void main(String[] args) {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils1.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
           // preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
           while (rs.next()) {

               String  cre = rs.getString("created_at");
               String created = rs.getString("hero");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("created_at");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
           }
        } catch (SQLException e) {
        	JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
}
