package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;

class EmployeeTest {

	EmployeeDAO edao = new EmployeeDAOImpl();
	EmployeeService es = new EmployeeServiceImpl(edao);
	
	// Employee DAO Tests
	@Test
	void testDAOGetAllEmployees() {
		assertNotNull(edao.getAllEmployees());
	}
	
	@Test
	void testDAOGetEmployeeByID() {
		Employee emp = edao.getEmployee(1);
		assertEquals(emp.getId(), 1);
	}
	
	// Employee Service Tests
	@Test
	void testServiceGetAllEmployees() {
		assertNotNull(es.getAllEmployees());
	}
	
	@Test
	void testServiceGetEmployeeByID() {
		Employee emp = es.getEmployee(1);
		assertEquals(emp.getId(), 1);
	}
	
	@Test
	void testServiceGetEmployeeByEmail() {
		Employee emp = es.getEmployeeByEmail("sadam@gmail.com");
		assertEquals(emp.getEmail(), "sadam@gmail.com");
	}
	
}
