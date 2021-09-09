package com.revature;

import java.lang.reflect.Proxy;
import java.util.Scanner;

// we can import classes/ methods and interfaces from another project
import com.something.Adult;
import com.something.Person;

public class App {

	public static void main(String[] args) {
	
		Adult a1 = new Adult("Arnold", 30, "Innsbruck", "Austria");
		
		// I want to modify the method at runtime
		// But I can't because it's not my code (it's from an external framework)
//		a1.introduce();
		
		/**
		 * Reflection API is used to examine or modify the behavior of classes/methods/interfaces at runtime.
		 */
		
		// Get a ClassLoader from the original object that we want to create a proxy for
		ClassLoader a1ClassLoader = a1.getClass().getClassLoader();
		
		// capture all the interfaces that the original object implements
		Class[] interfaces = a1.getClass().getInterfaces();
		
		// Create a proxy for our Adult object
		Person proxyA1 = (Person) Proxy.newProxyInstance(a1ClassLoader, interfaces, new PersonInvocationHandler(a1));
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a method for Arnold the object to do (either introduce or sayAge)!");
		String method = scan.next();
		
		if (method.equals("introduce")) {
			
			proxyA1.sayAge();
		
		} else if (method.equals("sayAge")) {
			a1.sayAge();
		}
		
		ClassInspector.listDeclaredMethods(Adult.class);
		
		
		
	}

}






