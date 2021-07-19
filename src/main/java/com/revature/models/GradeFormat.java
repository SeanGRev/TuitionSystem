package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade_formats")
public class GradeFormat {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="description", nullable = false)
	private String description;
	
	public GradeFormat() {
		super();
	}
	
	public GradeFormat(String description) {
		super();
		this.description = description;
	}

	public GradeFormat(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "GradeFormat [id=" + id + ", description=" + description + "]";
	}
	
}
