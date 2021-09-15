package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServiceTests {
	
	private EmployeeDao mockdao;
	private EmployeeService eserv;
	
	@Before
	public void setup() {
		
		mockdao = mock(EmployeeDao.class);
		eserv = new EmployeeService(mockdao);
		/**
		  * We are declaring the dependency of the object within the class
		  * via the constructor injection we defined in the EploseeService.java class
		  */
	}
	
	@After
	public void teardown() {
		eserv = null;
		mockdao = null;
	}
	
	// Happy Path Scenario
	@Test
	public void testConfirmLogin_success() {
		
		
		// we need to create a "fake database" of employee objects
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(43, "Clint", "Barton", "Hawkeye", "arrows");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);

		when(mockdao.findAll()).thenReturn(dummyDb);
		/**
		 * WHAT are we expecting when WHAT happens?
		 * 
		 * WHEN the service layer ACTUALLY calls confirmLogin() with username "Hawkeye" and password "arrows"
		 * and THEN calls the DAO layer to return data, the mocked dao will intercept
		 * the call with our hard-coded dummyDb ArrayList,
		 * THEN we are EXPECTING to return hawkeye (based on the logic of our Service method).
		 */
		
		// expected, actual
		assertEquals(e2, eserv.confirmLogin("Hawkeye", "arrows"));
	}	
	
	@Test
	public void testFailConfirmLogin_returnNull() {
		
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(43, "Clint", "Barton", "Hawkeye", "arrows");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		// expected, actual
		assertNull(eserv.confirmLogin("Hawkeye", "swords")); // this is the wrong password!
		
	}
	
}
