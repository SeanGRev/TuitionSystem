package com.revature.models;

public class ReimbursementID {

	private int id;
	
	private String employee_email;
	
	private int event_id;
	
	private double amount;
	
	private int missed_hours;
	
	private String grade;
	
	private String description;

	public ReimbursementID(String employee_email, int event_id, double amount, int missed_hours, String grade,
			String description) {
		super();
		this.employee_email = employee_email;
		this.event_id = event_id;
		this.amount = amount;
		this.missed_hours = missed_hours;
		this.grade = grade;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getMissed_hours() {
		return missed_hours;
	}

	public void setMissed_hours(int missed_hours) {
		this.missed_hours = missed_hours;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
