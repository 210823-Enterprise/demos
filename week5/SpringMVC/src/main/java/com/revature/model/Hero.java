package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // JPA is the specification and Hibernate is the Implementation
@Table(name="heroes")
public class Hero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "h_name", unique = true, nullable = false)
	private String name;
	
	// no need to add the @Column annotation if you're not adding extra constraints etc...
	// @Transient annotation would exclude it from the table construction shout out @Ryan
	private String superPower;
	
	@Column(nullable = false, name="h_has_cape")
	private boolean hasCape;

	public Hero(int id, String name, String superPower, boolean hasCape) {
		super();
		this.id = id;
		this.name = name;
		this.superPower = superPower;
		this.hasCape = hasCape;
	}
	
	public Hero(String name, String superPower, boolean hasCape) {
		super();
		this.name = name;
		this.superPower = superPower;
		this.hasCape = hasCape;
	}

	public Hero() {
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

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public boolean isHasCape() {
		return hasCape;
	}

	public void setHasCape(boolean hasCape) {
		this.hasCape = hasCape;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", superPower=" + superPower + ", hasCape=" + hasCape + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasCape ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((superPower == null) ? 0 : superPower.hashCode());
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
		Hero other = (Hero) obj;
		if (hasCape != other.hasCape)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (superPower == null) {
			if (other.superPower != null)
				return false;
		} else if (!superPower.equals(other.superPower))
			return false;
		return true;
	}

}
