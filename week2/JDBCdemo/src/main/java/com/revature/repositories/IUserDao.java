package com.revature.repositories;

import com.revature.models.User;

/**
 * DAO is a data access object
 * 
 * it is used to separate our persistence logic from our business logic
 *
 */
public interface IUserDao {
	
	int insert(User u); // we aim to return the primary key of the user inserted into the DB

	// TODO: add other abstract methods

}
