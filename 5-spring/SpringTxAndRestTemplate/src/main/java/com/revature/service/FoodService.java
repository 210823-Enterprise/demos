package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.FoodRepo;
import com.revature.model.Food;

@Service
public class FoodService {
	
	// @TRansactional on Service methods 
	//In the case that multiple dao methods were being called,
	// we want to make sure that those methods are fired 
	// against the DB in one unit of work (transaction)
	
	// SLFj is a logging abstraction for Spring
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FoodRepo foodRepo;
	
	// create -> add a Food object to out DB
	// Everytime that this method is invoked, I want to begin a new transaction
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Food add(Food food) {
		return foodRepo.save(food);
	}
	
	@Transactional(propagation=Propagation.REQUIRED) // this is the default setting for all transactional annotations.
	public void remove(int id) {
		try {
			foodRepo.deleteById(id);
		} catch (IllegalArgumentException e) {
			logger.warn("id can't be null to deleteById()");
		}
	}
	
	// we want to make sure that this method may only READ from the DB
	@Transactional(readOnly=true)
	public Optional<Food> findById(int id) {
		
		try {
			 return foodRepo.findById(id);
		} catch (IllegalArgumentException e) {
			logger.warn("id can't be null to findById()");
			return null;
		}

	}
	
	// findAll
	@Transactional(readOnly=true)
	public List<Food> findAllFoods() {
		
		return foodRepo.findAll();
		
	}
	 
	// findByName
	@Transactional(readOnly=true)
	public Optional<Food> findByName(String food) {
		
		try {
			// go back to your Food repo and change this to an Optional return type
			 return foodRepo.findByDishNameIgnoreCase(food);
		} catch (IllegalArgumentException e) {
			logger.warn("id can't be null to findById()");
			return null;
		}

	}
}
