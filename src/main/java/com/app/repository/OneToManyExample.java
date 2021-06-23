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
public class OneToManyExample {
    private static final String QUERY = "select v.Vendorint as id ,i.Item as item ,i.Description as description,i.CurrentQuantity as qty,v.Name as name,v.Phoneint as phone from inventory i  join vendor v where v.VendorInt=i.Vendorint and v.Vendorint=?";

    public static void main(String[] args) {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils2.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, 2);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();


            // Step 4: Process the ResultSet object.
           while (rs.next()) {

               String  gid = rs.getString("id");
               String name = rs.getString("item");
               String address = rs.getString("description");
                String begin = rs.getString("qty");
                String state = rs.getString("name");
               String phone = rs.getString("phone");




               System.out.println("id " + gid);
               System.out.println("name " + name);

               System.out.println("product " + address);

               System.out.println("qty " + begin);
               System.out.println("description " + state);


           }
        } catch (SQLException e) {
        	JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
}
