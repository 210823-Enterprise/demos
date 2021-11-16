package com.revature.stack;

public class App {

	public static void main(String[] args) {
		SimpleStack myStack = new SimpleStack(4);
		myStack.push(20);
		myStack.push(40);
		myStack.push(60);
		myStack.push(80);

		// Set up a while loop to continuously pop
		// all the recently added values of the stack
		while(!myStack.isEmpty()){
			
			long value = myStack.pop();
			System.out.println(value); // we should see 80 first because that's the last value added
		}
		
		// Demo the Challenge Solution here:
		System.out.println(reverseStringSolution("Hello World"));
	}
	
	/**
	 * Challenge: First Create a class called CharStack whose underlying
	 * array consists of a char[] (instead of long[]). 
	 * Modify all the necessary variables to a char data type.
	 * 
	 * Once associates have the String Stack class, 
	 * have them implement the following method:
	 */
	public static String reverseString(String str){ 
		
		// instantiate a CharStack object and use its
		// methods to return the reversed String
		
		return null;
	}
	
	// Solution!
	public static String reverseStringSolution(String str){
		
		int stackSize = str.length(); // get the max stack size
		
		CharStack stringStack = new CharStack(stackSize); // we make the CharStack obj.
		
		for(int j = 0; j < str.length(); j++){
			char ch = str.charAt(j); // getting a char from the input string
			stringStack.push(ch);
		}
		
		String result = "";
		
		while(!stringStack.isEmpty()){
			char ch = stringStack.pop(); // save the value as the last in (LIFO)
			result = result+ ch; // appending to the output to the result.
		}
		
		return result;
	}

}
