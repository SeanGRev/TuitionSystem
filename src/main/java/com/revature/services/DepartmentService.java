package com.revature.services;

import java.util.List;

import com.revature.models.Department;

public interface DepartmentService {

	public Department getDepartment(int id);
	
	public List<Department> getAllDepartments();
	
}
