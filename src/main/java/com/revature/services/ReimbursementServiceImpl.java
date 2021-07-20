package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.models.Attachment;
import com.revature.models.Presentation;
import com.revature.models.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService{

	public ReimbursementDAO rdao;
	
	public ReimbursementServiceImpl(ReimbursementDAO rdao) {
		this.rdao = rdao;
	}
	
	@Override
	public Reimbursement getReimbursement(int id) {
		return rdao.getReimbursement(id);
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		return rdao.getAllReimbursement();
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement rei) {
		return rdao.addReimbursement(rei);
	}

	@Override
	public List<Presentation> getPresentations(int reid) {
		List<Presentation> presentations = rdao.getAllPresentations();
		List<Presentation> result = new ArrayList<Presentation>();
		
		for(Presentation p : presentations) {
			if(p.getReimbursement().getId() == reid) {
				result.add(p);
			}
		}
		
		return result;
	}

	@Override
	public List<Attachment> getAttachments(int reid) {
		List<Attachment> attachments = rdao.getAllAttachments();
		List<Attachment> result = new ArrayList<Attachment>();
		
		for(Attachment a : attachments) {
			if(a.getReimbursement().getId() == reid) {
				result.add(a);
			}
		}
		
		return result;
	}
	
}
