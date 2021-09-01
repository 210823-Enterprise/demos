package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection; // this is JDBC
import java.sql.DriverManager; // this is JDBC
import java.sql.SQLException;
import java.util.Properties;

/**
 * Singleton Class is a software design pattern that ensures there will be one
 * single instance of that class.
 * 
 * -- private constructors 
 * -- static field of an instance of the class to be returned 
 * -- leverage a public static getInstance() (our getInstance method is the getConnection() method
 * 
 * The connection to our DB will be established by a singleton class which will
 * contain all the necessary driver information (jdbc url, username, password).
 */
public class ConnectionUtil {

	private static Connection conn = null;

	/**
	 *  we want to make the constructor PRIVATE so it can't be instantiated any other way
	 *  than our getConnection() method
	 */
	private ConnectionUtil() {
		super();
	}

	/**
	 *  The following method is designed to return the ONE single instance of this 
	 *  class if it exists, or instantiate it if if doesn't.
	 */
	public static Connection getConnection() {

		try { // check if the ConnectionUtil instance exists or is open first...
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			// TODO: add logging stmt to tell the devs that something went wrong
			return null;
		}

		// The Properties object is instantiated to fetch a stream of properties from a file
		Properties prop = new Properties();

		String url = "";
		String username = "";
		String password = "";

		try {
			// Use the Properties object to fetch properties from a specified file path (application.properties)
			prop.load(new FileReader(
					"C:\\Users\\SophieGavrila\\Desktop\\demos\\week2\\JDBCdemo\\src\\main\\resources\\application.properties"));
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			/**
			 * When the method getConnection is called,the DriverManager will attempt to locate a 
			 * suitable driver from amongst those loaded at initialization and those loaded 
			 * explicitly using the same class loader as the current application. 
			 */
			conn = DriverManager.getConnection(url, username, password);

			// TODO: Change this to a logging statement once we implement Log4J
			System.out.println("Connection successful!");

		} catch (IOException e) {
			// TODO add some logging
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO log an error!
			System.out.println();
			return null;
		}
		
		// If we establish a connection, return that connection
		return conn;
	}
}
