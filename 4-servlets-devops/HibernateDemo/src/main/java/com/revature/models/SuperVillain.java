package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="supervillains")
public class SuperVillain {
	
	@Id
	@Column(name="villain_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int svillId;
	
	@Column
	private String name;
	
	@Column
	private String superPower;
	
	@Column
	private double bounty;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Crime> crimes;

	public SuperVillain(int svillId, String name, String superPower, double bounty, List<Crime> crimes) {
		super();
		this.svillId = svillId;
		this.name = name;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
	}

	public SuperVillain(String name, String superPower, double bounty, List<Crime> crimes) {
		super();
		this.name = name;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
	}

	public SuperVillain() {
		super();
	}

	@Override
	public String toString() {
		return "SuperVillain [svillId=" + svillId + ", name=" + name + ", superPower=" + superPower + ", bounty="
				+ bounty + ", crimes=" + crimes + "]";
	}
	
	

}
