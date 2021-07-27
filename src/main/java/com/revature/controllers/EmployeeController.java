package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.app.App;
import com.revature.dao.DepartmentDAO;
import com.revature.dao.DepartmentDAOImpl;
import com.revature.models.CommandJson;
import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.models.EmployeeID;
import com.revature.models.LoginCredentials;
import com.revature.services.DepartmentService;
import com.revature.services.DepartmentServiceImpl;
import com.revature.services.EmployeeService;
import io.javalin.http.Handler;

public class EmployeeController {
	
	EmployeeService es;
	
	DepartmentDAO ddao = new DepartmentDAOImpl();
	DepartmentService ds = new DepartmentServiceImpl(ddao);
	
	Gson gson = new Gson();
	
	public EmployeeController(EmployeeService es) {
		this.es = es;
	}
	
	public Handler getEmployeeById = (ctx) -> {
		String input = ctx.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Employee em = es.getEmployee(id);
		
		if(em != null) {
			ctx.result(gson.toJson(em));
		} else {
			ctx.status(400);
		}
	};
	
	public Handler getAllEmployees = (ctx) -> {
		
		List<Employee> em = es.getAllEmployees();
		
		if(em == null) {
			ctx.result("[]");
		} else {
			ctx.result(gson.toJson(em));
		}
	};
	
	public Handler addEmployee = (ctx) -> {
		EmployeeID emid = gson.fromJson(ctx.body(),EmployeeID.class);
		
		Department dep = ds.getDepartment(emid.getDep_id());
		Employee em = new Employee(emid.getFirst_name(), emid.getLast_name(), emid.getEmail(), emid.getPassword(),
				emid.isActive(), dep, emid.getSupervisor_id(), emid.getBen_co_id());
		
		em = es.addEmployee(em);
		
		if(em != null) {
			ctx.result(gson.toJson(em));
			ctx.status(201);
		} else {
			ctx.status(400);
		}
	};
	
	public Handler getDepartments = (ctx) -> {
		
		List<Department> deps = ds.getAllDepartments();
		
		if(deps == null) {
			ctx.result("[]");
		} else {
			ctx.result(gson.toJson(deps));
		}
	};
	
	public Handler employeeLogin = (ctx) -> {
		LoginCredentials lc = gson.fromJson(ctx.body(), LoginCredentials.class);
		
		Employee user = es.getEmployeeByEmail(lc.getEmail());
		
		if(user != null) {
			ctx.result(gson.toJson(user));
		} else {
			ctx.status(400);
		}
		
	};
	
}
