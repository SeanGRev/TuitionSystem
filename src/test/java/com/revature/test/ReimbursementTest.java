package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.Attachment;
import com.revature.models.Presentation;
import com.revature.services.ReimbursementService;
import com.revature.services.ReimbursementServiceImpl;

class ReimbursementTest {

	ReimbursementDAO redao = new ReimbursementDAOImpl();
	ReimbursementService res = new ReimbursementServiceImpl(redao);
	
	// Test Reimbursement DAO
	@Test
	void testDAOGetAllReim() {
		assertNotNull(redao.getAllReimbursement());
	}
	
	@Test 
	void testDAOReimByID(){
		Reimbursement rei = redao.getReimbursement(1);
		assertEquals(rei.getId(), 1);
	}
	
	@Test
	void testDAOGetAttachments() {
		assertNotNull(redao.getAllAttachments());
	}
	
	@Test
	void testDAOGetPresentations() {
		assertNotNull(redao.getAllPresentations());
	}

	// Test Reimbursement Service
	@Test
	void testServiceGetAllReim() {
		assertNotNull(res.getAllReimbursements());
	}
	
	@Test 
	void testServiceGetReimByID(){
		Reimbursement rei = res.getReimbursement(1);
		assertEquals(rei.getId(), 1);
	}
	
	@Test
	void testServiceGetAttachments() {
		Attachment atch = res.getAttachments(1).get(0);
		assertEquals(atch.getReimbursement().getId(), 1);
	}
	
	@Test
	void testServiceGetPresentations() {
		Presentation pres = res.getPresentations(1).get(0);
		assertEquals(pres.getReimbursement().getId(), 1);
	}
}
