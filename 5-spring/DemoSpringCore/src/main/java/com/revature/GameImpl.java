package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class GameImpl implements Game {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

	// == fields ==
	
	@Autowired // add after configuring the beans.xml file
	private NumberGenerator numberGenerator;
	private int guessCount = 10;
	private int number;
	private int guess;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;
	
	/**
	  * // == constructors ==  Do this first, THEN Setter Injection
	  * ======== CONSTRUCTOR INJECTION ==========
	  * 
	   	
	   	public GameImpl(NumberGenerator numberGenerator) {
				// Constructor Injection!
			this.numberGenerator = numberGenerator;
				// then modify the Context...
		}
	
	 */

	// == public methods ==
	
	/**
	 * === SETTER INJECTION ==== (do after Constructor Injection)
	 * 
	 * -= Just create a simple setter for the numberGenerator field
	 *
	   	public void setNumberGenerator(NumberGenerator numberGenerator) {
			this.numberGenerator = numberGenerator;
		}
	 *
	 */

	@Override
	public void reset() {
		smallest = 0;
		guess = 0;
		remainingGuesses = guessCount;
		biggest = numberGenerator.getMaxNumber();
		number = numberGenerator.next();
		log.debug("the number is {}", number);
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public int getGuess() {
		return guess;
	}

	@Override
	public void setGuess(int guess) {
		this.guess = guess;
	}

	@Override
	public int getSmallest() {
		return smallest;
	}

	@Override
	public int getBiggest() {
		return biggest;
	}

	@Override
	public int getRemainingGuesses() {
		return remainingGuesses;
	}

	@Override
	public void check() {

		checkValidNumberRange();

		if (validNumberRange) {
			if (guess > number) {
				biggest = guess - 1;
			}

			if (guess < number) {
				smallest = guess + 1;
			}
		}

		remainingGuesses--;
	}

	@Override
	public boolean isValidNumberRange() {
		return validNumberRange;
	}

	@Override
	public boolean isGameWon() {
		return guess == number;
	}

	@Override
	public boolean isGameLost() {
		return !isGameWon() && remainingGuesses <= 0;
	}

	// == private methods ==
	private void checkValidNumberRange() {
		validNumberRange = (guess >= smallest) && (guess <= biggest);
	}

}
