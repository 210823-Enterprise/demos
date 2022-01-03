package com.revature;

import org.springframework.context.annotation.ComponentScan;

/**
 * This class does literally the same thing that the Beans.xml file does when we load it
 *
 */

@ComponentScan(basePackages = "com.revature") // search for all classes with @Component annotation
public class AppConfig {
	
//	@Bean(name = "basicSpellChecker")
//	public BasicSpellChecker createBasicSpellChecker(){
//		
//		return new BasicSpellChecker();
//	}
//	
//	@Bean(name = "advancedSpellChecker")
//	public AdvancedSpellChecker createAdvancedSpellChecker(){
//		
//		return new AdvancedSpellChecker();
//	}
//	
//	// use setter injection
//	@Bean(name = "emailClient")
//	public EmailClient createEmailClient(){
//		
//		EmailClient emailClient = new EmailClient();
//		emailClient.setSpellChecker(createAdvancedSpellChecker());
//		
//		return emailClient;
//	}
	
	// 2 Types of Dependency Injection
	// + Constructor Injection
	// + Setter Injection

}
