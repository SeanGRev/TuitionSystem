package com.revature.dao;

import java.util.List;

import com.revature.models.Department;

public interface DepartmentDAO {

	public Department getDepartment(int id);
	
	public List<Department> getAllDepartments();
	
}
