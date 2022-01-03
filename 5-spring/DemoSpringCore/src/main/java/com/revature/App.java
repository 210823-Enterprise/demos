package com.revature;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	private static final String CONFIG_LOCATION = "beans.xml";

	public static void main(String[] args) {

		// create context (IoC container)
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

		/**
		 * Above we are instantiating an XML specific configuration of the XML file
		 * located at the String that we passed through.
		 * 
		 * ConfigurableApplicationContext is an interface, and
		 * ClassPathXmlApplicationContext implements it.
		 */

		/**
		 * Next Step: Instantiate a Number Generator Bean: 
		 * 
		 * We pass NAME and TYPE of the BEAN we want the IoC container to instantiate. 
		 * The id points to the actual Implementaiton Class, and the TYPE argument points 
		 * to the interface that the class implements.
		 */
		NumberGenerator numberGen = context.getBean("myNumberGenerator", NumberGenerator.class);
		/**
		 * This '.class' method is used in Java for code Reflection. Generally you can
		 * gather meta data for your class such as the full qualified class name, list
		 * of constants, list of public fields, etc, etc.
		 * 
		 * .class files are a byproduct that you don't normally see or manipulate by hand.
		 * This is pointing to compiled java-bytecode that will be inspected at runtime
		 */
		
		// call method next() to get a random number
		int number = numberGen.next();
		
		log.info("The number is {}", number);
		
		// == do after Game Impl bean configuration ==
		// Get Game Bean from Context
		Game game = context.getBean(Game.class); // overloaded version
		
		// call reset() method on game...this will call Game's NumberGenrator() object
		game.reset(); // This will throw a NullPointerException! We never intialized the NumberGenerator object 
					  // that belongs to this bean.
		
		/**
		 * ===== Enter CONSTRUCTION INJECTION =====
		 */
		
		context.close(); // closes the context to prevent memory/resource leaks.
		
		// Note that when you create the Spring Bean it's a Singlton bean which is the default scope for a Bean
	}
}
