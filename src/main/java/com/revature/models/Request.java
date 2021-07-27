package com.revature.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="message", nullable=false)
	private String message;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "reimbursement_id")
	private Reimbursement reimbursement;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "reviewer_id")
	private Employee reviewer;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "sender_id")
	private Employee sender;
	@Column(name="approval_status", nullable=true)
	private boolean approval_status;
	@Column(name="submission_date", nullable=false)
	private LocalDate submission_date;
	@Column(name="urgent", nullable=false)
	private boolean urgent;
	
	public Request() {
		super();
	}

	public Request(String message, Reimbursement reimbursement, Employee reviewer, Employee sender,
			boolean approval_status, LocalDate submission_date, boolean urgent) {
		super();
		this.message = message;
		this.reimbursement = reimbursement;
		this.reviewer = reviewer;
		this.sender = sender;
		this.approval_status = approval_status;
		this.submission_date = submission_date;
		this.urgent = urgent;
	}
	
	public Request(int id, String message, Reimbursement reimbursement, Employee reviewer, Employee sender,
			boolean approval_status, LocalDate submission_date, boolean urgent) {
		super();
		this.id = id;
		this.message = message;
		this.reimbursement = reimbursement;
		this.reviewer = reviewer;
		this.sender = sender;
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

	public Reimbursement getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(Reimbursement reimbursement) {
		this.reimbursement = reimbursement;
	}

	public Employee getReviewer() {
		return reviewer;
	}

	public void setReviewer(Employee reviewer) {
		this.reviewer = reviewer;
	}

	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}

	public boolean isApproval_status() {
		return approval_status;
	}

	public void setApproval_status(boolean approval_status) {
		this.approval_status = approval_status;
	}

	public LocalDate getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(LocalDate submission_date) {
		this.submission_date = submission_date;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", message=" + message + ", reimbursement=" + reimbursement
				+ ", reviewer=" + reviewer + ", sender=" + sender + ", approval_status=" + approval_status
				+ ", submission_date=" + submission_date + ", urgent=" + urgent + "]";
	}
	
}
