package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="presentations")
public class Presentation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="reimbursement_id", nullable = false)
	private int reimbursement_id;
	
	@Column(name="description", nullable = false)
	private String description;
	
	public Presentation() {
		super();
	}

	public Presentation(int reimbursement_id, String description) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.description = description;
	}

	public Presentation(int id, int reimbursement_id, String description) {
		super();
		this.id = id;
		this.reimbursement_id = reimbursement_id;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Presentation [id=" + id + ", reimbursement_id=" + reimbursement_id + ", description=" + description
				+ "]";
	}
	
}
