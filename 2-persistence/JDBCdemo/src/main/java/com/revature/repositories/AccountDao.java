package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDao implements IAccountDao {
	
	private static Logger log = Logger.getLogger(AccountDao.class);

	@Override
	public int insert(Account a) { // this method returns the PrimaryKey of the Account we just inserted
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO sophiag.accounts (balance, acc_owner) VALUES (?, ?) RETURNING sophiag.accounts.id";
			
			// PreparedStatment....
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, a.getBalance());
			stmt.setInt(2, a.getOwnerId());
			
			ResultSet rs;
			
			if ((rs = stmt.executeQuery()) != null) {
				
				rs.next();
				int id = rs.getInt(1);
				return id;
			} 
			
		} catch (SQLException e) {
			log.warn("Unable to insert Account");
			e.printStackTrace();
			return -1;
		}
				
		return -1;
	}

	@Override   // 11:10am ET
	public List<Account> findAll() { // here we have to make an actual query
		
		// start out with an empty arraylist of accounts
		List<Account> accList = new ArrayList<Account>();
		
		// obtain a connection, surround with try with resources block
		try(Connection conn = ConnectionUtil.getConnection()) {
		
			// create a statement + a sql string to pass through and execute against the DB
			 Statement stmt =  conn.createStatement();
			 
			 String sql = "SELECT * FROM accounts";
	
			 // send the statement to the DB
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 // iterate through the response while(rs.next())
			 while(rs.next()) {
				
			 	// for each row, grab the data of that account
				 int id = rs.getInt("id"); // you can specify the column number OR you can specify the column name
				 double balance = rs.getDouble("balance");
				 
			 	// construct the account object
				 Account a = new Account(id, balance);
		
				 // add the account object to the list
				 accList.add(a);
			 }
			 
		} catch (SQLException e) {
		// catch a sql error if necessary
			log.warn("A SQL EXception occurred when querying all accounts");
			e.printStackTrace();
		}
		
		// return the account list
		return accList;
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByOwner(int userId) {

		List<Account> ownedAccounts	= new ArrayList<Account>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT sophiag.accounts.id, sophiag.accounts.balance FROM sophiag.accounts\r\n" + 
					"	INNER JOIN sophiag.users_account_jt \r\n" + 
					"		ON sophiag.accounts.id = sophiag.users_account_jt.account 	\r\n" + // this was previously set to acc_owner	
					"			WHERE sophiag.users_account_jt.acc_owner = ?;"; // this will have to be a joins statement
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// how do we set the ?
			stmt.setInt(1, userId); 
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				
				Account a = new Account(id, balance);
				
				// in the case that there are duplicates, DON'T add them to the arraylist
				if(!ownedAccounts.contains(a)) {
					ownedAccounts.add(a);
				}	
			}

		} catch (SQLException e) {
			log.warn("Failed to retrieve all accounts owned by user with id " + userId);
			e.printStackTrace();
		}
		
		return ownedAccounts;
		
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
