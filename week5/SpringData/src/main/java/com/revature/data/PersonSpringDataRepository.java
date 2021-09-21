package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Person;

@Repository
public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{

	// SpringData automatically generates DAO Impl class of this interface  & all crud methods
	
}
