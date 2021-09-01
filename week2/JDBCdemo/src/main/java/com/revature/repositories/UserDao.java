package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDao implements IUserDao{

	@Override
	public int insert(User u) { // Think about the User that you take in as being generated from the input that a user gives through the console
		
		try {
			
			// Capture the single instance of the JDBC Connection (this is called a session)
			Connection conn = ConnectionUtil.getConnection();
			
			// We start with a SQL String -- "RETURNING" allows us to return the PK of the user inserted/created
			String sql = "INSERT INTO sophiag.users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING sophiag.users.id";
			
			/*
			 * Defend against SQL injection with a Prepared Statement!
			 * If you don't use a Prepared Statement, a malicious actor could try to insert a statement like "DROP TABLE USERS".
			 * SQL Injection is typically the #1 Cyber Threat listed by OWASP. https://owasp.org/www-project-top-ten/
			 */
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			/**
			 *  Here we are replacing the ?'s of the sql String with the instance variables of the
			 *  User u object passed as a parameter to be persisted. 
			 */
			stmt.setString(1, u.getUsername());  // The "1" represents the 1st ? in the SQL insertion String
			stmt.setString(2, u.getPassword());
			
			
			// Transposing an the ENUM from Java -> SQL, is tough because we have to accommodate for a separate custom ENUM type.
			stmt.setObject(3,  u.getRole(), Types.OTHER);
			
			/**
			 * When we run stmt.executeQuery(), it returns a ResultSet Object.
			 * The ResultSet Interface has all of the methods we need to iterate over 
			 * the returned data.
			 */
			ResultSet rs; 
			
			// first we check to see if the returned result set is NOT null...
			if ((rs = stmt.executeQuery()) != null)  {
				// move the cursor of the ResultSet forward 1 with next()
				rs.next(); 
				// all we need is the FIRST column's data (which is the PK of the inserted User)
				int id = rs.getInt(1); // the "1" parameter represents the column of data that we want
				// if everything goes well, we return that fetched PK	
				return id; 
			}
			
		} catch (SQLException e) {
			// TODO add logging!
			e.printStackTrace();
		}
		
		/**
		 *  Since this method returns an int (as specified in the IUserDao Interface),
		 *  return -1 if things go wrong inserting a User in the DB, because Users can't
		 *  have a negative ID 
		 */
		return -1; 
	}

}
