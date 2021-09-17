package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CrimeDao;
import com.revature.dao.SuperVillainDao;
import com.revature.models.Crime;
import com.revature.models.SuperVillain;

public class Driver {

	static CrimeDao cdao = new CrimeDao();
	static SuperVillainDao svdao = new SuperVillainDao();
	
	public static void main(String[] args) {

		System.out.println("Starting the program.....");
		
		Crime c1 = new Crime("Arson", "setting the city ablaze");
		Crime c2 = new Crime("Freeze", "covering the city in ice");
		Crime c3 = new Crime("Time Manipulation", "freezin' time, robbin' banks");
				
		System.out.println("Inserting the transient object into the DB with the .save() session method....");
		
		cdao.insert(c1);
		cdao.insert(c2);
		cdao.insert(c3);
		
		List<Crime> crimeList = new ArrayList<Crime>();
		crimeList.add(c1);
		crimeList.add(c2);
		crimeList.add(c3);
		
		
		SuperVillain joker = new SuperVillain("Joker", "evilness", 300_000_000, crimeList);
		
		svdao.insert(joker);
		System.out.println("Retireving all Villain Objects");
		
		// Printing out each Villain object wihtin the returned list
		svdao.selectAll().forEach(System.out::println);
		
		System.out.println("Ending the program.....");
	}
	
	
	public int add(int x, int y) {
		
		
		return x + y;
	}
	
	

}
