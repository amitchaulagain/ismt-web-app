package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Insert PrepareStatement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class InsertPStatementExample {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
        "  (id, name, email, country, password) VALUES " +
        " (?, ?, ?, ?, ?);";

    public static void main(String[] argv) throws SQLException {
        InsertPStatementExample createTableExample = new InsertPStatementExample();
        createTableExample.insertRecord();
    }

    public void insertRecord() throws SQLException {
        System.out.println(INSERT_USERS_SQL);

        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter id");
        int id=scanner.nextInt();
        System.out.println("Enter name");
        String name=scanner.next();

        System.out.println("Enter email");
        String email=scanner.next();

        System.out.println("Enter country");
        String country=scanner.next();


        System.out.println("Enter password");
        String password=scanner.next();



        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, country);
            preparedStatement.setString(5, password);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
        	JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}
