package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection; // this is JDBC
import java.sql.DriverManager; // this is JDBC
import java.sql.SQLException;
import java.util.Properties;

// Singleton design pattern instantiates an object ONCE

/**
 * Singleton design pattern
 * 
 * -- private constructors
 * -- static field of an instance of the class to be returned
 * -- leverage a public static getInstance() (our getInstance method in this case is the getConnection() method
 * 
 * 
 * @author SophieGavrila
 *
 */
public class ConnectionUtil {
	
	private static Connection conn = null;
	
	// we want to make the constructor PRIVATE 
	private ConnectionUtil() {
		super();
	}
	
	
	// in a singleton design pattern you create a static "getINstynace() method
	public static Connection getConnection() {
		
		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
		// implement an error log here	
			return null;
		}
		
		
		Properties prop = new Properties();
		
		String url = "";
		String username = "";
		String password = "";
		
		try {
			prop.load(new FileReader("C:\\Users\\SophieGavrila\\Desktop\\demos\\week2\\JDBCdemo\\src\\main\\resources\\application.properties"));
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
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

		return conn;
	}
}
