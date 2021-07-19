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
@Table(name="presentations")
public class Presentation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "reimbursement_id")
	private Reimbursement reimbursement;
	
	@Column(name="description", nullable = false)
	private String description;
	
	public Presentation() {
		super();
	}

	public Presentation(Reimbursement reimbursement, String description) {
		super();
		this.reimbursement = reimbursement;
		this.description = description;
	}

	public Presentation(int id, Reimbursement reimbursement, String description) {
		super();
		this.id = id;
		this.reimbursement = reimbursement;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Presentation [id=" + id + ", reimbursement=" + reimbursement + ", description=" + description
				+ "]";
	}
	
}
