package com.revature.services;

import java.util.List;

import com.revature.models.Request;

public interface RequestService {

	public Request getRequest(int id);
	
	public List<Request> getAllRequests();
	
	public List<Request> getRequestByEmployeeId(int eid);
	
	public List<Request> getRequestByReviewerId(int eid);
	
}
