package com.revature.models;

public class EmployeeID {

	/*
	 * Employee Model for creating class from JSON
	 */
	private int id;
    
	private String first_name;
    
	private String last_name;
    
	private String email;
    
	private String password;
    
	private boolean active;
    
	private int dep_id;
    
	private int supervisor_id;
    
	private int ben_co_id;
    
	//Constructors
	public EmployeeID() {
		super();
	}
	
	public EmployeeID(String first_name, String last_name, String email, String password, boolean active, int dep_id,
			int supervisor_id, int ben_co_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.dep_id = dep_id;
		this.supervisor_id = supervisor_id;
		this.ben_co_id = ben_co_id;
	}

	public int getId() {
		return id;
	}

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

	public int getDep_id() {
		return dep_id;
	}

	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", active=" + active + ", dep_id=" + dep_id + ", supervisor_id="
				+ supervisor_id + ", ben_co_id=" + ben_co_id + "]";
	}
		
}
