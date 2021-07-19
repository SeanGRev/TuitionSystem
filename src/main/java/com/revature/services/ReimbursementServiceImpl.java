package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.models.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService{

	public ReimbursementDAO rdao;
	
	public ReimbursementServiceImpl(ReimbursementDAO rdao) {
		this.rdao = rdao;
	}
	
	@Override
	public Reimbursement getReimbursment(int id) {
		return rdao.getReimbursement(id);
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		return rdao.getAllReimbursement();
	}

}
