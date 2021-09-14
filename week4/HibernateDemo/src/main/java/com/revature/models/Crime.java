package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// JPA = Java Persistence API
// JPA is the specification, Hibernate is the implementation

@Entity
@Table(name="crime_table")
public class Crime implements Serializable {
	
	// Our ID will be auto generated by the database
	@Id
	@Column(name="crime_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) // this will auto generate a primary key
	private int id;
	
	@Column(name="crime_name", unique=true,  nullable=false)
	private String crimeName;
	
	@Column(name="description")
	private String description;
	
	public Crime() {
	
	}

	public Crime(int id, String crimeName, String description) {
		super();
		this.id = id;
		this.crimeName = crimeName;
		this.description = description;
	}

	public Crime(String crimeName, String description) {
		super();
		this.crimeName = crimeName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCrimeName() {
		return crimeName;
	}

	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Crime [id=" + id + ", crimeName=" + crimeName + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crimeName == null) ? 0 : crimeName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		if (crimeName == null) {
			if (other.crimeName != null)
				return false;
		} else if (!crimeName.equals(other.crimeName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
