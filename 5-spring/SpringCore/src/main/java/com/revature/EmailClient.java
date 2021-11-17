package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailClient {

	// The SpellChecker object is a dependency and a property

	
	@Autowired
	@Qualifier("advancedSpellChecker")
	private SpellChecker spellChecker;
//	private BasicSpellChecker basicSpellChecker;
	
	// Tight coupling 
//	public EmailClient(SpellChecker spellChecker) {
//		this.spellChecker = spellChecker; // At runtime, the type of SpellChecker will be determined
//											// by the class I pass thru the constructor
//	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	void sendEmail(String emailMessage) {
		// call a spell checker to check the message before sending
		spellChecker.checkSpelling(emailMessage);
		// Imagine the logic to actually send the message...
	}
	 

}
