package com.revature.data;

import org.springframework.stereotype.Repository;

import com.revature.annotaion.TrackTime;

/**
 * The Spring @Repository annotation is a specialization of the @Component
 * annotation which indicates that an annotated class is a �Repository�, which
 * can be used as a mechanism for encapsulating storage, retrieval, and search
 * behavior which emulates a collection of objects.
 */
@Repository
public class Dao1 {
	
	@TrackTime
	public String retrieveSomething() {
		
		return "Dao1";
	}

}
