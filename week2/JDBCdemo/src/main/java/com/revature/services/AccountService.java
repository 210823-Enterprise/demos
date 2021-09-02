package com.revature.services;

import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.repositories.IAccountDao;

public class AccountService {
	
	// Inject the dependency that Account Service needs to persist data
	static IAccountDao adao = new AccountDao();
	
	// create an openAccount method that will include a scanner and call  the accDao.insert() method
	
	private static Scanner scan = new Scanner(System.in);
	
	
	public Account openAccount(User u) {
		
		// it prompts the user to enter an initial deposit
		
		// it reads back to the user the deposit entered
		
		
		// it creates a new account with the User's id as the accounts ownerId property....
		
		// then it calls the adao.insert method to persist the account to the DB
		
		// make sure you grab the generated PK from the insert method
		
		// return the full account object (with it's generated PK as the id)
		
		return null;
		
	}
	

}
