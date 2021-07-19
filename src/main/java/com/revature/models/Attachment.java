package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="attachments")
public class Attachment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "reimbursement_id")
	private Reimbursement reimbursement;
	
	@Column(name="attachment", nullable = false)
	private String attachment;
	
	public Attachment() {
		super();
	}

	public Attachment(Reimbursement reimbursement, String attachment) {
		super();
		this.reimbursement = reimbursement;
		this.attachment = attachment;
	}

	public Attachment(int id, Reimbursement reimbursement, String attachment) {
		super();
		this.id = id;
		this.reimbursement = reimbursement;
		this.attachment = attachment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reimbursement getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(Reimbursement reimbursement) {
		this.reimbursement = reimbursement;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "Attachment [id=" + id + ", reimbursement=" + reimbursement + ", attachment=" + attachment + "]";
	}
	
}
