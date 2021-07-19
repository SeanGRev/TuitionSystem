package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	public Reimbursement getReimbursement(int id);
	
	public List<Reimbursement> getAllReimbursement();
	
}
