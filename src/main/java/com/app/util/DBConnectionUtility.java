package com.app.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionUtility {

	public static Connection getDBConnection() {

		String DATASOURCE_CONTEXT = "java:comp/env/jdbc/crudDB";

		Connection result = null;
		try {
			Context initialContext = new InitialContext();
			DataSource datasource = (DataSource) initialContext.lookup(DATASOURCE_CONTEXT);
			if (datasource != null) {
				result = datasource.getConnection();
			} else {
				log("Failed to lookup datasource.");
			}
		} catch (NamingException ex) {
			log("Cannot get connection: " + ex);
		} catch (SQLException ex) {
			log("Cannot get connection: " + ex);
		} catch (Throwable te) {
			te.printStackTrace();
		}
		return result;
	}

	private static void log(Object aObject) {
		System.out.println(aObject);
	}
}
