package com.revature;

import java.lang.reflect.Proxy;
import java.util.Scanner;

// we can import classes/ methods and interfaces from another project
import com.something.Adult;
import com.something.Person;

/**
 * Reflection API is used to examine or modify the behavior of
 * classes/methods/interfaces at runtime.
 * 
 * It comes from the Java.lang.reflect package
 * 
 * https://www.geeksforgeeks.org/reflection-in-java/
 */
public class App {

	public static void main(String[] args) {

		Adult a1 = new Adult("Arnold", 30, "Innsbruck", "Austria");

		/**
		 * I want to modify the method at runtime But I can't because it's not my code
		 * (it's from an external framework)
		 */
		a1.introduce();

		/**
		 * Reflection API is used to examine or modify the behavior of
		 * classes/methods/interfaces at runtime.
		 * 
		 * So that I can change the runtime behavior of interfaces and their class
		 * implementations!
		 */

		// Get a ClassLoader from the original object that we want to create a proxy for
		ClassLoader a1ClassLoader = a1.getClass().getClassLoader();

		// capture all the interfaces that the original object implements
		Class[] interfaces = a1.getClass().getInterfaces();

		// Create a proxy for our Adult obj
		Person proxyA1 = (Person) Proxy.newProxyInstance(a1ClassLoader, interfaces, new PersonInvocationHandler(a1));

		/*
		 * What is a Proxy?
		 * 
		 * Proxy is a design pattern. We create and use proxy objects when we want to
		 * add or modify some functionality of an already existing class. The proxy
		 * object is used instead of the original one.
		 * 
		 * Usually, the proxy objects have the same methods as the original one and in
		 * Java, proxy classes usually extend the original class. The proxy has a handle
		 * to the original object and can call the method on that. (InvocationHandler)
		 */
		
		// Call method we have modified in Person Invocation Handler!
		proxyA1.introduce();

		/**
		 * What if we wanted to select whether we'd call the Dynamic Proxy behavior or
		 * the original method's behavior?
		 * 
		 * Below would be kind of silly...
		 */
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a method for Arnold the object to do (either introduce or sayAge)!");
		String method = scan.next();

		if (method.equals("introduce")) {

			// call from proxy with intercepted metho behavior
			proxyA1.sayAge();

		} else if (method.equals("sayAge")) {
			// call from the original Class's method behavior (without hello)
			a1.sayAge();
		}

		/**
		 * We used inspection to create a method that prints
		 * all the methods that belong to the Adult class
		 *  bnb
		 */
		ClassInspector.listDeclaredMethods(Adult.class);

	}

}
