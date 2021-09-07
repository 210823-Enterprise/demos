package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.revature.model.Employee;

public class ComparatorDriver {

	public static void main(String[] args) {
		
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee zayn = new Employee("Zayn Smith", 40);
		Employee mary = new Employee("Mary Shelly", 60);
		Employee abby = new Employee("Abby McCormick", 30);
		Employee xavier = new Employee("Xavier Hall", 25);
		
		employees.add(zayn);
		employees.add(mary);
		employees.add(abby);
		employees.add(xavier);
		
		// When we call forEach() we need to specify the functionality for the Consumer Interface's accept() method
		employees.forEach((e) -> System.out.println(e));
		
		// Remember that Consumer comes from the java.util.function package which is where a lot of functional interfaces come from.
		
		System.out.println("==========================================================");
		 
		// this is a comparable object
		NameSorter ns = new NameSorter();
		
		Collections.sort(employees, ns);
		
		employees.forEach((e) -> System.out.println(e)); 
		
		
		// Challenge 1:  call the Collections.sort() method and create a Comparator anonymous class to sort in DESCENDING order
		
		
		
		// CHallenge 2: call the Colelctions.sort() method and create a LAMBDA function to sort the employees by age in ASCENDING order
		
		
		// complete by 12:00pm ET
		

	}
}


// When we use the Comparator interface, we define an EXTERNAL class to the object that we want to sort
// We implement the comparator interface on this class and then override the compare() method (note that this is
// different from the compareTo() method from the comparable interface.

class NameSorter implements Comparator<Employee> {

	// we are sorting by NAME.
	@Override
	public int compare(Employee emp1, Employee emp2) {

		return emp1.getName().compareTo(emp2.getName());
	} 

}


