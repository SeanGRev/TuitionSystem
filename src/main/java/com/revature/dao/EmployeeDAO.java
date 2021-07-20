package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {

	public Employee getEmployee(int id);

	List<Employee> getAllEmployees();
	
	public Employee addEmployee(Employee em);
	
}
