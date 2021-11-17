package com.revature.streams;

import java.util.Arrays;
import java.util.List;

public class Driver {

	/**
	 * Streams - Stream API was introduces in Java 8. It is used process a
	 * collection of objects.
	 * 
	 * A stream is NOT a collection! It is a sequence of object references that
	 * support various methods that can be pipelined to produce the desired result.
	 * 
	 * We use Streams to take input from Collections, Arrays, or I/O channels.
	 * 
	 */
	public static void main(String[] args) {
		
		
		List<String> bingoNums = Arrays.asList(
				"D40", "D46",
				"B12", "B6",
				"G53", "G49", "G15", "g64",
				"I13", "I22", "I29",
				"O71"
				);
		
		
	// Let's print all of the Bingo Numbers in column G	
	
		// traditional way we've been operating on colelctions
		bingoNums.forEach(n -> {
		
			if (n.startsWith("G")) {
				System.out.println(n);
			} // notice that we're missing the lowercase
			
		});
		
		System.out.println("============================================");
		
		bingoNums.stream()
			.map(String::toUpperCase) // map applies a given function to each elemente within the data structure
			// here we are referencing the method from a specific class that we want to perform on each element.
		
			// Method referencing Class::Method
			// String::toUpperCase
			.filter(s -> s.startsWith("G")) // only find the g numbers
			.sorted()
			.forEach(System.out::println);
		
		
		
		bingoNums.forEach(System.out::println);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
