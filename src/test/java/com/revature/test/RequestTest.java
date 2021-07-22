package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.dao.RequestDAO;
import com.revature.dao.RequestDAOImpl;
import com.revature.models.Request;
import com.revature.services.RequestService;
import com.revature.services.RequestServiceImpl;

class RequestTest {

	RequestDAO rdao = new RequestDAOImpl();
	RequestService rs = new RequestServiceImpl(rdao);
	
	// Test RequestDAO
	@Test
	void testDAOGetAllRequests() {
		assertNotNull(rdao.getAllRequests());
	}
	
	@Test
	void testDAOGetRequestByID(){
		Request req = rdao.getRequest(1);
		assertEquals(req.getId(), 1);
	}
	
	// Test Request Service
	@Test
	void testServiceGetAllRequests() {
		assertNotNull(rs.getAllRequests());
	}
	
	@Test
	void testServiceGetRequestByID() {
		Request req = rs.getRequest(1);
		assertEquals(req.getId(), 1);
	}
	
	@Test
	void testServiceGetAllEmployeeSentRequests() {
		assertNotNull(rs.getEmployeeSentRequests(1));
	}
	
	@Test
	void testServiceGetRequestByReviewerId() {
		assertNotNull(rs.getRequestByReviewerId(2));
	}
}
