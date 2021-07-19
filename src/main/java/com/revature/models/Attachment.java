package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attachments")
public class Attachment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="reimbursement_id", nullable = false)
	private int reimbursement_id;
	
	@Column(name="attachment", nullable = false)
	private String attachment;
	
	public Attachment() {
		super();
	}

	public Attachment(int reimbursement_id, String attachment) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.attachment = attachment;
	}

	public Attachment(int id, int reimbursement_id, String attachment) {
		super();
		this.id = id;
		this.reimbursement_id = reimbursement_id;
		this.attachment = attachment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReimbursement_id() {
		return reimbursement_id;
	}

	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "Attachment [id=" + id + ", reimbursement_id=" + reimbursement_id + ", attachment=" + attachment + "]";
	}
	
}
