package com.revature;

import org.springframework.stereotype.Component;

@Component
public class AdvancedSpellChecker implements SpellChecker {

	public void checkSpelling(String emailMessage) {

		if (emailMessage != null) {
			System.out.println("Checking spelling using AdvancedSpellChecker");
			// determining the language of the email
			// checking grammatical errors
			// checking spellings (imagine all this logic)
			System.out.println("Spell CHecking Completed!");
		} else {
			throw new RuntimeException("An exception occurred while checking spelling.");

		}

	}

}
