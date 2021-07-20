package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.RequestDAO;
import com.revature.models.Request;

public class RequestServiceImpl implements RequestService{

	public RequestDAO rdao;
	
	public RequestServiceImpl(RequestDAO rdao) {
		this.rdao = rdao;
	}
	
	public Request getRequest(int id) {
		return rdao.getRequest(id);
	}
	
	public List<Request> getAllRequests(){
		return rdao.getAllRequests();
	}

	@Override
	public List<Request> getEmployeeSentRequests(int eid) {
		List<Request> requests = rdao.getAllRequests();
		List<Request> result = new ArrayList<Request>();
		
		for(Request r : requests) {
			if(r.getSender().getId() == eid) {
				result.add(r);
			}
		}
		return result;
	}

	@Override
	public List<Request> getRequestByReviewerId(int eid) {
		List<Request> requests = rdao.getAllRequests();
		List<Request> result = new ArrayList<Request>();
		
		for(Request r : requests) {
			if(r.getReviewer().getId() == eid) {
				result.add(r);
			}
		}
		return result;
	}

	@Override
	public Request addRequest(Request req) {
		return rdao.addRequest(req);
	}
	
	
	
}
