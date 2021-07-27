package com.revature.models;

public class RequestID {

	private int id;
	
	private String message;

	private int reimbursement_id;

	private String reviewer_email;

	private String sender_email;
	
	private boolean approval_status;
	
	private String submission_date;
	
	private boolean urgent;

	public RequestID(String message, int reimbursement_id, String reviewer_email, String sender_email,
			boolean approval_status, String submission_date, boolean urgent) {
		super();
		this.message = message;
		this.reimbursement_id = reimbursement_id;
		this.reviewer_email = reviewer_email;
		this.sender_email = sender_email;
		this.approval_status = approval_status;
		this.submission_date = submission_date;
		this.urgent = urgent;
	}
	
	public RequestID(int id, String message, int reimbursement_id, String reviewer_email, String sender_email,
			boolean approval_status, String submission_date, boolean urgent) {
		super();
		this.id = id;
		this.message = message;
		this.reimbursement_id = reimbursement_id;
		this.reviewer_email = reviewer_email;
		this.sender_email = sender_email;
		this.approval_status = approval_status;
		this.submission_date = submission_date;
		this.urgent = urgent;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getReimbursement_id() {
		return reimbursement_id;
	}

	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}

	public String getReviewer_email() {
		return reviewer_email;
	}

	public void setReviewer_email(String reviewer_email) {
		this.reviewer_email = reviewer_email;
	}

	public String getSender_email() {
		return sender_email;
	}

	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}

	public boolean isApproval_status() {
		return approval_status;
	}

	public void setApproval_status(boolean approval_status) {
		this.approval_status = approval_status;
	}

	public String getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	
}
