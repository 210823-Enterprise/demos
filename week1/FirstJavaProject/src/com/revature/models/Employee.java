package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

/**
 *  * A Java Bean IS a type of POJO, but more specific and specialized
 * 
 * -- it's serializable
 * -- have getters/setters
 * -- have an overridden hashcode() and equals() method
 * 
 * 
 * @author SophiaGavrila
 *
 */
public class Employee extends Person implements Serializable{

	
	// all the properties of Person are present in Employee but abstracted away from us
	
	private String dept;

	
	// here we're calling the constructor of the 
	public Employee(String name, int age, double height, double weight, String dept) {
		super(name, age, height, weight);
		this.dept = dept;
	}

	// all the getters/setters like getName() and getAge() already exist! Because Inheritance!

	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + " dept =" + dept;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept); // this began in Java version 7
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dept, other.dept);
	}

	
	
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		if (dept == null) {
//			if (other.dept != null)
//				return false;
//		} else if (!dept.equals(other.dept))
//			return false;
//		return true;
//	}
//	
	
	
}
