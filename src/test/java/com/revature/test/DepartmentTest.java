package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.dao.DepartmentDAO;
import com.revature.dao.DepartmentDAOImpl;
import com.revature.models.Department;
import com.revature.services.DepartmentService;
import com.revature.services.DepartmentServiceImpl;

class DepartmentTest {

	DepartmentDAO ddao = new DepartmentDAOImpl();
	DepartmentService ds = new DepartmentServiceImpl(ddao);
	
	// Test Department DAO
	@Test
	void testDAOGetAllDepartments() {
		assertNotNull(ddao.getAllDepartments());
	}
	
	@Test
	void testDAOGetDepartmentByID() {
		Department dep = ddao.getDepartment(1);
		assertEquals(dep.getId(), 1);
	}

	// Test Department Service
	@Test
	void testServiceGetAllDepartments() {
		assertNotNull(ds.getAllDepartments());
	}
	
	@Test
	void testServiceGetDepartmentByID() {
		Department dep = ds.getDepartment(1);
		assertEquals(dep.getId(), 1);
	}
	
}
