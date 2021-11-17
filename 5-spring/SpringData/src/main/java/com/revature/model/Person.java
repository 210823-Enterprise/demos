package com.revature.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity // import form the JPA
@NamedQuery(name="find_all_people", query="select p from Person p")
public class Person {
	
	@Id
	@GeneratedValue
	private int id;  // the above 2 annotations declare this field as an auto-generated primary key
	
	// these columns will be created by default
	private String name;
	
	// we use the @Column to specify things like nullable=false, or if the column has a different name, etc...
	private String location;
	private Date birthdate; // import from Java.util
	
	
	public Person(int id, String name, String location, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;
	}
	public Person(String name, String location, Date birthdate) {
		super();
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;
	}
	public Person() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthdate=" + birthdate + "]";
	}


}
