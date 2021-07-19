package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
    
    @Column(name="first_name", nullable = false)
	private String first_name;
    
    @Column(name="last_name", nullable = false)
	private String last_name;
    
    @Column(name="email", nullable = false)
	private String email;
    
    @Column(name="password", nullable = false)
	private String password;
    
    @Column(name="active", nullable = false)
	private boolean active;
    
    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;
    
    @Column(name="supervisor_id", nullable = false)
	private int supervisor_id;
    
    @Column(name="ben_co_id", nullable = false)
	private int ben_co_id;
    
	//Constructors
	public Employee() {
		super();
	}
	

	public Employee(String first_name, String last_name, String email, String password,
			boolean active, Department department, int supervisor_id, int ben_co_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.department = department;
		this.supervisor_id = supervisor_id;
		this.ben_co_id = ben_co_id;
	}

	public Employee(int id, String first_name, String last_name, String email, String password, boolean active, Department department, int supervisor_id,
			int ben_co_id) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.department = department;
		this.supervisor_id = supervisor_id;
		this.ben_co_id = ben_co_id;
	}


	public int getId() {
		return id;
	}
	
	//Getters and Setters


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public int getBen_co_id() {
		return ben_co_id;
	}


	public void setBen_co_id(int ben_co_id) {
		this.ben_co_id = ben_co_id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", active=" + active + ", department=" + department + ", supervisor_id="
				+ supervisor_id + ", ben_co_id=" + ben_co_id + "]";
	}
		
}
