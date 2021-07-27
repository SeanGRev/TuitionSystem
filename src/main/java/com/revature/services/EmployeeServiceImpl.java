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
	
	public Employee addEmployee(Employee em) {
		return edao.addEmployee(em);
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		List<Employee> employees = edao.getAllEmployees();
		Employee em = new Employee();
		for(Employee e : employees) {
			if(e.getEmail().equals(email)) {
				em = e;
			}
		}
		return em;
	}
	

}
