package com.revature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello") // this can be reached at localhost:8080/hello
@RestController
public class HelloController {
	
	@GetMapping
	public String hello() {
		
		// just writing a comment
		return "What's up!?";
		
	}
	

}
