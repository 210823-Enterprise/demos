package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailApplicaiton {
	
	// https://www.youtube.com/watch?v=ZwcHeLhvuq4&t=891s&ab_channel=ProgrammingTechie
	
	public static void main(String[] args) {
		
//		EmailClient emailClient = new EmailClient(new AdvancedSpellChecker());
		
		// beans.xml (XML configuration)
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		// AppConfig Class
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// to instantiate a Email CLient bean
		// A Spring Bean is nothing more than a Java PoJo that is managed by the 
		EmailClient emailClient = applicationContext.getBean("emailClient", EmailClient.class);
		
		// send first message
		emailClient.sendEmail("Hey, " + 
				"This is my first email message.");
		
		// send second message
		emailClient.sendEmail("Hey, " + 
				"This is my second email message.");
		
	}

}
