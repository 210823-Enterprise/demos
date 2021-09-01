package com.revature;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.IUserService;
import com.revature.services.UserService;

public class App {

	public static void main(String[] args) {
		
		User u1 = new User("Batman", "pass", Role.Admin, new ArrayList<Account>());

		
		System.out.println("please enter your username");
		
		// scanner gets the username, and password.... and we build a new User obj from the console 
		
		// call our service method to REGISTER it
		IUserService userv = new UserService();
		userv.register(new User("Spiderman", "password", Role.Customer, new ArrayList<Account>()));		
	}

}
