package com.revature;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.util.ConnectionUtil;

public class App {

	public static void main(String[] args) {
		
		User u1 = new User("Tester", "pass", Role.Admin, new ArrayList<Account>());
		
		UserDao ud = new UserDao();
		
		int didItExecuteCorrectly = ud.insert(u1);
		
		System.out.println(didItExecuteCorrectly);

	}

}
