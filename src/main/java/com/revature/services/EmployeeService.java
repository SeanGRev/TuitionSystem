package com.revature.services;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(int id);
	
	public List<Employee> getAllEmployees();
	
	public Employee addEmployee(Employee em);
	
	public Employee getEmployeeByEmail(String email);
	
}
