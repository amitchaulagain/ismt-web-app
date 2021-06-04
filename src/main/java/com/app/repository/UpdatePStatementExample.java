package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Update PreparedStatement JDBC Example
 * @author Ramesh Fadatare
 *
 */
public class UpdatePStatementExample {

    private static final String UPDATE_USERS_SQL = "update users set name = ?, email=? where id = ?;";

    public static void main(String[] argv) throws SQLException {
        UpdatePStatementExample updateStatementExample = new UpdatePStatementExample();
        updateStatementExample.updateRecord();
    }

    public void updateRecord() throws SQLException {
        final String UPDATE_USERS_SQL = "update users set name = ?, email=?,password=?,country=? where id = ?;";
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, "harish");
            preparedStatement.setString(2, "hari@gmail.com");
            preparedStatement.setString(3, "hari@gmail.com");
            preparedStatement.setString(4, "hari@gmail.com");

            preparedStatement.setInt(3, 5);


            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
        	JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}
