package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.model.Animal;

public class CollectionDriver {
	
	public static void main(String[] args) {
		
		
		/**
		 * List
		 * 
		 * - ordered Collection (sometimes called a sequence)
		 * - may contain duplicates
		 * - We use the list interface when we want to use the following operations
		 * 
		 * 
		 * 		+ Positional access
		 * 			- manipulating elements based on their numerical position in the list
		 * 			- for example use methods like get(), set(), add(), remove() - think CRUD
		 * 
		 * 		+ Search
		 * 
		 * 		+ Iteration 
		 * 
		 * 		+ Range-view (how big is the list?)
		 * 
		 */
		
		List<Animal> animalList = new ArrayList<Animal>();
		
		Animal a1 = new Animal("Dog", 12); // we have no way of defining whether a1 and a3 are the same
		Animal a2 = new Animal("Tiger", 4);
		Animal a3 = new Animal("Dog", 12);
		
		animalList.add(a1);
		animalList.add(a2);
		animalList.add(a3);
		
		for (Animal a : animalList) {
			
			System.out.println(a.hashCode()); // after we override the hashCode(), it will determine that a1 and a3 are indeed duplicates
			
		}
		
		// vectors are synchronized (thread safe)
		
		// vectors increase 100% when they need to expand.
		List<Integer> numbers = new Vector<Integer>();
		
		numbers.add(3);
		numbers.add(74);
		numbers.add(-9000);
		
		System.out.println(numbers);
		
		/**
		 * Sets
		 * 
		 * - unordered
		 * - DO NOT allow duplicates
		 * 		+ They maintain a strong contract of the object and its hashcode and equals() method
		 * 
		 */
		
		System.out.println("==================== SETS BELOW =========================");
		
		Set<Animal> animalSet = new LinkedHashSet<Animal>(); // linkedHashset
		
		animalSet.add(a1); // this is the same as a3
		animalSet.add(a2);
		animalSet.add(a3); // the compiler won't complain but the set isn't going to do it
		
		for (Animal a : animalSet) {
			
			System.out.println(a);
			
		}


		/**
		 * Queue
		 * 
		 * - A collection used to hold elements prior to processing
		 * - FIFO order (first in, first out)
		 * 
		 * 
		 * 
		 */
		
		System.out.println("============= Queues! ");
		
		Queue<Animal> animalQ = new LinkedList<Animal>();
		
		// You can add duplicates in a Queue!!
		animalQ.add(a1);
		animalQ.add(a2);
		animalQ.add(a3);
		
		while(animalQ.size() != 0) {
			
			System.out.println("Queue size: " + animalQ.size());
			System.out.println("Processing... " + animalQ.poll()); // poll() removes the head of the queue
			
			
		}
		
		/**
		 *  Collections utility Class! Note the S! This is different from the Collection Interface....
		 *  
		 *  - static methods that operate on a collection...
		 *  - polymorphic algorithms
		 */
		
		System.out.println("vector before sorting");

		System.out.println(numbers);
		
		System.out.println("sorting vector....");
		Collections.sort(numbers); // Collections is a Utility class
		// this Collections Class only exists to call methods on Collection data structures
		
		System.out.println(numbers);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
