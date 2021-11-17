package com.revature;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.data.PersonSpringDataRepository;
import com.revature.model.Person;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository repository; // 
//	PersonJpaRepository repository;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// change from insert() to save()
		logger.info("Inserting -> {} ", repository.save(new Person("Tara", "Berlin", new Date())));
		logger.info("Inserting -> {} ", repository.save(new Person("Bob", "Jones", new Date())));
		
		logger.info("User Id 1 -> {} ", repository.findById(1));
		
		logger.info("Update 1 -> {}", repository.save(new Person(1, "Peter", "Smith", new Date())));
		
		logger.info("All users -> {}", repository.findAll());
		
		
	}

}
