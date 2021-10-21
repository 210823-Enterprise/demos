package com.revature.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController // RestController automatically puts ResponseBody on every public method (that is mapped) within this class
@RequestMapping("/users") // we can access the methods of this controller at http://localhost:5000/app/users
@CrossOrigin(origins = "*") // this exposes this controller to all ports
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// returing a Set to prevent duplicates
	@GetMapping
	public ResponseEntity<Set<User>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
		return ResponseEntity.ok(userService.findByUsername(username));
	}
	
       @GetMapping("/{id}")
       public User findByUserId(@PathVariable("id") int id) {
	   	return userService.getById(id);
       }	

	@PostMapping("/add")
	public ResponseEntity<User> insert(@Valid @RequestBody User u) {

		return ResponseEntity.ok(userService.insert(u));
	} 
}
