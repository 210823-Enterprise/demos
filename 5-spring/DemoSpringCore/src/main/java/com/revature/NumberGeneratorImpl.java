package com.revature;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {
	
	// == fields ==
	private final Random random = new Random();
	
	private int maxNumber = 100;

	// == public methods ==
	public int next() {
		return random.nextInt(maxNumber); // between 0 and maxNumber;
	}

	public int getMaxNumber() {
		return maxNumber;
	}
	
	/**
	 * After creating this implementation class, the next step is 
	 * to configure the Spring Container to create a bean for us
	 * (A NumberGenerator Bean)
	 * 
	 * A container can be configured many different ways
	 * here we'll configure it through XML
	 */

}
