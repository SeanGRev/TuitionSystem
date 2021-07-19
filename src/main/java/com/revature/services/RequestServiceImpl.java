package com.revature.services;

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
	
}
