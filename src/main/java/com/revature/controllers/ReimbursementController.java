package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.CommandJson;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

import com.revature.models.Reimbursement;

public class ReimbursementController {

	ReimbursementService rs;
	Gson gson = new Gson();
	
	public ReimbursementController(ReimbursementService rs) {
		this.rs = rs;
	}
	
	public Handler getAllReimbursements = (ctx) ->{
		List<Reimbursement> reimbursements = rs.getAllReimbursements();
		
		if(reimbursements != null) {
			ctx.result(gson.toJson(reimbursements));
		} else {
			ctx.result("[]");
		}
	};
	
	public Handler getReimbursementById = (ctx) -> {
		String input = ctx.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Reimbursement r = rs.getReimbursment(id);
		
		if(r != null) {
			ctx.result(gson.toJson(r));
		} else {
			ctx.result("[]");
		}
	};
	
}
