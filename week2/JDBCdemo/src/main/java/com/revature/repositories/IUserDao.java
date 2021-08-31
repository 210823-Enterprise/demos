package com.revature.repositories;

import com.revature.models.User;

/**
 * DAO is a data access object
 * 
 * it is used to separatee or persistance logic from our business logic
 * @author SophieGavrila
 *
 */
public interface IUserDao {
	
	int insert(User u); // we aim to return the primary key of the user inserted into the DB

	
	// all other methods tomorrow

}
