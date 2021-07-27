package com.revature.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.CommandJson;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.models.Request;
import com.revature.models.RequestID;
import com.revature.services.ReimbursementService;
import com.revature.services.ReimbursementServiceImpl;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.services.RequestService;

import io.javalin.http.Handler;

public class RequestController {

	RequestService rs;
	ReimbursementDAO redao = new ReimbursementDAOImpl();
	ReimbursementService res = new ReimbursementServiceImpl(redao);
	EmployeeDAO edao = new EmployeeDAOImpl();
	EmployeeService es = new EmployeeServiceImpl(edao);
	Gson gson = new Gson();
	
	public RequestController(RequestService rs) {
		this.rs = rs;
	}
	
	public Handler getAllRequests = (ctx) ->{
		List<Request> requests = rs.getAllRequests();
		
		if(requests != null) {
			ctx.result(gson.toJson(requests));
		} else {
			ctx.result("{}");
		}
	};
	
	public Handler getRequestById = (ctx) -> {
		String input = ctx.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Request req = rs.getRequest(id);
		
		if(req != null) {
			ctx.result(gson.toJson(req));
		} else {
			ctx.result("{}");
		}
	};
	
	public Handler getEmployeeSentRequests = (ctx) -> {
		String input = ctx.pathParam("id");
		int eid;
		try {
			eid = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			eid = -1;
		}
		
		List<Request> req = rs.getEmployeeSentRequests(eid);
		
		if(req != null) {
			ctx.result(gson.toJson(req));
		} else {
			ctx.result("{}");
		}
	};
	
	public Handler getEmplyeeReviewRequests = (ctx) -> {
		String input = ctx.pathParam("id");
		int eid;
		try {
			eid = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			eid = -1;
		}
		
		List<Request> req = rs.getRequestByReviewerId(eid);
		if(req != null) {
			ctx.result(gson.toJson(req));
		} else {
			ctx.result("{}");
		}
	};
	
	public Handler addRequest = (ctx) -> {
		RequestID reid = gson.fromJson(ctx.body(), RequestID.class);
		
		Reimbursement reimbursement = res.getReimbursement(reid.getReimbursement_id());
		Employee reviewer = es.getEmployeeByEmail(reid.getReviewer_email());
		Employee sender = es.getEmployeeByEmail(reid.getSender_email());
		
		Request req = new Request(reid.getMessage(), reimbursement, reviewer, sender,
				reid.isApproval_status(), LocalDate.parse(reid.getSubmission_date()), reid.isUrgent());
		
		req = rs.addRequest(req);
		
		if(req != null) {
			ctx.result(gson.toJson(req));
			ctx.status(201);
		} else {
			ctx.status(400);
		}
	};
	
	public Handler updateRequest = (ctx) -> {
		RequestID reid = gson.fromJson(ctx.body(), RequestID.class);
		
		Reimbursement reimbursement = res.getReimbursement(reid.getReimbursement_id());
		Employee reviewer = es.getEmployeeByEmail(reid.getReviewer_email());
		Employee sender = es.getEmployeeByEmail(reid.getSender_email());
		
		Request req = new Request(reid.getId(), reid.getMessage(), reimbursement, reviewer, sender,
				reid.isApproval_status(), LocalDate.parse(reid.getSubmission_date()), reid.isUrgent());
		
		req = rs.updateRequest(req);
		ctx.result((req != null) ? gson.toJson(req) : "{}");
	};
	
}
