package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.models.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	public EmployeeDAO edao;

	public EmployeeServiceImpl(EmployeeDAO edao) {
		this.edao = edao;
	}
	
	public Employee getEmployee(int id) {
		return edao.getEmployee(id);
	}
	
	public List<Employee> getAllEmployees() {
		return edao.getAllEmployees();
	}
	
}
