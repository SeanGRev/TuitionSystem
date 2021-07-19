package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.CommandJson;
import com.revature.models.Request;
import com.revature.services.RequestService;

import io.javalin.http.Handler;

public class RequestController {

	RequestService rs;
	Gson gson = new Gson();
	
	public RequestController(RequestService rs) {
		this.rs = rs;
	}
	
	public Handler getAllRequests = (ctx) ->{
		List<Request> requests = rs.getAllRequests();
		
		if(requests != null) {
			ctx.result(gson.toJson(requests));
		} else {
			ctx.result("[]");
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
			ctx.result("[]");
		}
	};
	
	
}
