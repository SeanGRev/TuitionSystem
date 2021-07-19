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
@Table(name="reimbursements")
public class Reimbursement {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@Column(name = "event_id", nullable = false)
	private int event_id;
	
	@Column(name="amount", nullable = false)
	private double amount;
	
	@Column(name="missed_hours", nullable = false)
	private int missed_hours;
	
	@Column(name="grade", nullable = true)
	private String grade;
	
	@Column(name="description", nullable = false)
	private String description;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(Employee employee, int event_id, double amount, int missed_hours, String grade,
			String description) {
		super();
		this.employee = employee;
		this.event_id = event_id;
		this.amount = amount;
		this.missed_hours = missed_hours;
		this.grade = grade;
		this.description = description;
	}

	public Reimbursement(int id, Employee employee, int event_id, double amount, int missed_hours, String grade,
			String description) {
		super();
		this.id = id;
		this.employee = employee;
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
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", employee=" + employee + ", event_id=" + event_id + ", amount="
				+ amount + ", missed_hours=" + missed_hours + ", grade=" + grade + ", description=" + description + "]";
	}
	
}
