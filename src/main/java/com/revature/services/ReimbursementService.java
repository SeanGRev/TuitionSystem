package com.revature.services;

import java.util.List;

import com.revature.models.Attachment;
import com.revature.models.Presentation;
import com.revature.models.Reimbursement;

public interface ReimbursementService {

	public Reimbursement getReimbursement(int id);
	
	public List<Reimbursement> getAllReimbursements();
	
	public Reimbursement addReimbursement(Reimbursement rei);
	
	public List<Presentation> getPresentations(int reid);
	
	public List<Attachment> getAttachments(int reid);
}
