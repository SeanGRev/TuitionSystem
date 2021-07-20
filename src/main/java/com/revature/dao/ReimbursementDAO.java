package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Attachment;
import com.revature.models.Presentation;

public interface ReimbursementDAO {

	public Reimbursement getReimbursement(int id);
	
	public List<Reimbursement> getAllReimbursement();
	
	public Reimbursement addReimbursement(Reimbursement rei);
	
	public List<Attachment> getAllAttachments();
	
	public List<Presentation> getAllPresentations();
	
}
