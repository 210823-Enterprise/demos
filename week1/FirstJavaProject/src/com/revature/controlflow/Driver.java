package com.revature.controlflow;

public class Driver {

	public static void main(String[] args) {
		
		// if - else statment
		
		int temp = 31;
		
		if (temp < 32) {
			System.out.println("It's too cold out!");
		} else {
			System.out.println("It's not too cold out...");
		}
		
		// ternary operator
		System.out.println((temp < 32) ? "COLD!" : "NOT COLD!" );
	
		
		int hungerLevel = 7;
		
		if (hungerLevel > 6) {
				
			System.out.println("Need food now!");
			
		} else if (hungerLevel >= 4 ) {
			System.out.println("I could snack");
		} else {
			System.out.println("Not hungry at all....");
		}
		
		

	}

}
