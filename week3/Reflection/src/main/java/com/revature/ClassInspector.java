package com.revature;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

// Look into Obejct Relational Mapping
public class ClassInspector {

	/**
	 * ere we will use Reflection to analyze all the methods of a class by 
	 * passing the Class name (like Adult.class) as a parameter.
	 * @param clazz (represents the class name we want to inspect) 
	 */
	public static void listDeclaredMethods(Class<?> clazz) {
		
		System.out.println("Listing all the declared methods of class: " + clazz.getName());
		Method[] methods = clazz.getDeclaredMethods();
		
		if (methods.length == 0) {
			System.out.println("\t There are no method in the class: " + clazz.getName());
		}
		
		for (Method method : methods) {
			
			// we don't care about seeing the class's inherited methods from the java.lang.Object Class
			if(method.getDeclaringClass() == Object.class) {
				continue;
			}
			
            System.out.println("\nMethod name: " + method.getName());
            System.out.println("\tMethod param count: " + method.getParameterCount());
            System.out.println("\tMethod declared class: " + method.getDeclaringClass());
            System.out.println("\tMethod declared annotations: " + Arrays.toString(method.getDeclaredAnnotations()));
			
            Parameter[] params = method.getParameters();
            
            for (Parameter param : params) {
                System.out.println("\t\tParameter name: " + param.getName());
                System.out.println("\t\tParameter type: " + param.getType());
                System.out.println("\t\tParameter annotations: " + Arrays.toString(param.getDeclaredAnnotations()));
            }
			
		}
		System.out.println();
		
	}
	
	
}
