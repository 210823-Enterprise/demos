package com.revature.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Food;
import com.revature.service.FoodService;

@RestController // this extends from @Controller (sterotype annotation) -> automatically infers
				// @ResponseBody
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	// all -> Get request
	@GetMapping("/all") // http://localhost:5000/food/all
	public List<Food> getAllFoods() {
		return foodService.findAllFoods();
	}

	// get by Id with @PathVariable
	@GetMapping("/{id}") // http:localhost:5000/food/6
	public Food getFoodById(@PathVariable("id") int id) {

		Optional<Food> returned = foodService.findById(id);
		// you CANNOT return an optional to the client

		return returned.isPresent() ? returned.get() : null;
	}

	// GET find -> RequestParam
	@GetMapping("/find")  // http:localhost:5000/food/find?name=pizza
	public Food findByName(@RequestParam("name") String food) {
		Optional<Food> returned = foodService.findByName(food);

		return returned.isPresent() ? returned.get() : null;
	}

	// POST add
	@PostMapping("/add")
	public Food addFood(@RequestBody Food food) {
		
		return foodService.add(food);
	}
	

	@DeleteMapping("/{id}")
	public void removeFood(@PathVariable("id") int id) {
		
		foodService.remove(id);
		
	}
}














