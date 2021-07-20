package com.revature.dao;

import java.util.List;

import com.revature.models.Request;

public interface RequestDAO {

	public Request getRequest(int id);
	
	public List<Request> getAllRequests();
	
	public Request addRequest(Request req);
	
}
