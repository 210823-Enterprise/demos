package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

public class SuperVillainDao {
	
	public int insert(SuperVillain sv) {
		
		// capture a Session
		Session ses = HibernateUtil.getSession();
		
		// import Transaction From Hibernate (not JPA)
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(sv); // the save() session method performs an insert on the database
		
		tx.commit(); // commit the transaction
		
		return pk; // return the auto-generated primary key
		
	}
	
	public List<SuperVillain> selectAll() {
		
		Session ses = HibernateUtil.getSession();
		
		// Hibernate supports a language called HQL....
		List<SuperVillain> vills = ses.createQuery("from SuperVillain", SuperVillain.class).list();
		
		return vills;
	}
	
	

}
