package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Food;

// Service
// Repository
// Controller -> Rest Controller

@Repository // stereotype annotation!
public interface FoodRepo extends JpaRepository<Food, Integer>{

	// Property Expressions
	public List<Food> findByOrderByDishName();
	// property expressions infer a custom SQL query based on the properties of the model class
	
	public Optional<Food> findByDishNameIgnoreCase(String dishName);
}
