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
public class OneToOneExample {
    private static final String QUERY = "select GID as id,Name as name,Address as address from gov g join state  s where g.gid=s.sgid";
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

               String  gid = rs.getString("id");
               String name = rs.getString("name");
               String address = rs.getString("address");
                String begin = rs.getString("TermBegin");
                String state = rs.getString("StateName");
                String population = rs.getString("Population");


               System.out.println("id " + gid);
               System.out.println("name " + name);

               System.out.println("address " + address);

               System.out.println("begin " + begin);
               System.out.println("state " + state);
               System.out.println("population " + population);


           }
        } catch (SQLException e) {
        	JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
}
