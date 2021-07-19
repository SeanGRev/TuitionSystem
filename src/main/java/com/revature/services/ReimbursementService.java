package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementService {

	public Reimbursement getReimbursment(int id);
	
	public List<Reimbursement> getAllReimbursements();
	
}
