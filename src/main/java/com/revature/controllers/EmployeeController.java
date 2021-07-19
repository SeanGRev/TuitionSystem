package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.app.App;
import com.revature.models.CommandJson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.http.Handler;

public class EmployeeController {
	
	EmployeeService es;
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
	
}
