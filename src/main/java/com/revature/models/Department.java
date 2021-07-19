package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="dep_head_id", nullable = false)
	private int dep_head_id;
	
	@Column(name="dep_name", nullable = false)
	private String dep_name;
	
	public Department() {
		super();
	}
	
	public Department(int dep_head_id, String dep_name) {
		super();
		this.dep_head_id = dep_head_id;
		this.dep_name = dep_name;
	}
	
	public Department(int id, int dep_head_id, String dep_name) {
		super();
		this.id = id;
		this.dep_head_id = dep_head_id;
		this.dep_name = dep_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDep_head_id() {
		return dep_head_id;
	}

	public void setDep_head_id(int dep_head_id) {
		this.dep_head_id = dep_head_id;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", dep_head_id=" + dep_head_id + ", dep_name=" + dep_name + "]";
	}
	
}
