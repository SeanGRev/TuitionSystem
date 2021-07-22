package com.revature.services;

import java.util.List;

import com.revature.dao.DepartmentDAO;
import com.revature.models.Department;

public class DepartmentServiceImpl implements DepartmentService {

	public DepartmentDAO ddao;
	
	public DepartmentServiceImpl(DepartmentDAO ddao) {
		this.ddao = ddao;
	}
	
	@Override
	public Department getDepartment(int id) {
		return ddao.getDepartment(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		return ddao.getAllDepartments();
	}
	
}
