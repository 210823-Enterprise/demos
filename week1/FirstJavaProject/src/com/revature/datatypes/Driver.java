package com.revature.datatypes;

public class Driver {
	
	/**
	 * In any Java Program the main() method is the starting point from where the
	 * compiler starts program execution.
	 * 
	 * @param args ... represents commands that could follow the class name when we
	 *             call the "java" execution command to execute the bytecode.
	 * 
	 *             We will talk later about what it means to be "public", "static",
	 *             and "void"....
	 */
	public static void main(String[] args) {

		System.out.println("Testing output to the console...");

		/**
		 * A literal is a source code representation of a fixed value. They are
		 * represented directly in the code without any computation.
		 * 
		 * Literals can be assigned to any primitive type variable. For example:
		 */

		boolean isCool = true; // 1 bit represents true or false value (either 0 or 1)
		byte reallySmallNumber = 127; // 8 bits of reserved memory -> max value is 127, min value -128.
		short shortNumber = 32767; // 16 bits of reserved mem
		char letter = 'm'; // 16 bits of memory that represent a character or an ASCII character's numeric
							// value
		int standardNum = 10_000_000; // 32 bits of reserve mem
		float lessPreciseDouble = 93.2f; // 32 bits of mem, allows you to make decimals, but it's-- less precise than a
											// double
		double decimal = 20.45; // 64 bits of mem
		long bigNumber = 12345678L; // 64 bits

		/*
		 * Casting
		 * 
		 * Type casting is used to convert objects or variables of one type into another
		 * 
		 * Widening Casting (Implicit) -- Automatic Type Conversion Widening a smaller
		 * primitive value to a bigger primitive type.
		 * 
		 * Narrowing Casting (Explicit) -- Need Explicit Conversion with () Narrowing a
		 * bigger primitive value to a small primitive value.
		 */

		byte a = 40;
		short b = a; // b == 40. a short has more reserved memory than a byte, so we can easily
						// convert a byte to a short.

		// byte anotherByte = b; // This isn't IMPLICITLY converted! We need to use
		// casting for this. More on that in a bit.
		int c = b;
		double d = c;
	
		
		// a double is larger than an integer
		double dub = 900.9;
		int myInt = (int) dub; // we are using NARROW Casting to transform a large datatype to a small one
		
		System.out.println("the double that has been explicitly cast to an int is now equal to " + myInt);
		
		int x = 4;
		int y = 10;
		
		System.out.println(x + y);
		
		// a String is NOT primitive data type. It is technically a class
		String name = "Spongebob";
		
		System.out.println(name + " is " + (x + y * 100) + " years old");
		
	
		
		// Everything above  that we've defined are Java Literals, which are simply hard-coded fixed values that we assign to a variable.
		
		
		
		
	}

}





