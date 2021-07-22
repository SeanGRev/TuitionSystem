package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Attachment;
import com.revature.models.CommandJson;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;
import com.revature.models.Employee;
import com.revature.models.Event;
import com.revature.models.Presentation;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.dao.EventDAO;
import com.revature.dao.EventDAOImpl;
import com.revature.services.EventService;
import com.revature.services.EventServiceImpl;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementID;

public class ReimbursementController {

	ReimbursementService rs;
	EmployeeDAO edao = new EmployeeDAOImpl();
	EmployeeService es = new EmployeeServiceImpl(edao);
	EventDAO evdao = new EventDAOImpl();
	EventService evs = new EventServiceImpl(evdao);
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
		
		Reimbursement r = rs.getReimbursement(id);
		
		if(r != null) {
			ctx.result(gson.toJson(r));
		} else {
			ctx.result("[]");
		}
	};
	
	public Handler addReimbursement = (ctx) -> {
		ReimbursementID reid = gson.fromJson(ctx.body(),ReimbursementID.class);
		
		Employee employee = es.getEmployeeByEmail(reid.getEmployee_email());
		Event event = evs.getEvent(reid.getEvent_id());
		
		Reimbursement rei = new Reimbursement(employee, event, reid.getAmount(), reid.getMissed_hours(), reid.getGrade(),
				reid.getDescription());
		
		rei = rs.addReimbursement(rei);
		
		if(rei != null) {
			ctx.result(gson.toJson(rei));
			ctx.status(201);
		} else {
			ctx.status(400);
		}
	};
	
	public Handler getReimbursementPresentations = (ctx) -> {
		String input = ctx.pathParam("id");
		int reid;
		try {
			reid = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			reid = -1;
		}
		
		List<Presentation> presentations = rs.getPresentations(reid);
		
		if(presentations != null) {
			ctx.result(gson.toJson(presentations));
		} else {
			ctx.result("[]");
		}
	};
	
	public Handler getReimbursementAttachments = (ctx) -> {
		String input = ctx.pathParam("id");
		int reid;
		try {
			reid = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			reid = -1;
		}
		
		List<Attachment> attachments = rs.getAttachments(reid);
		
		if(attachments != null) {
			ctx.result(gson.toJson(attachments));
		} else {
			ctx.result("[]");
		}
	};
	
}
