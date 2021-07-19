package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_types")
public class EventType {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="coverage", nullable = false)
	private double coverage;
	
	@Column(name="type", nullable = false)
	private String type;
	
	public EventType() {
		super();
	}

	public EventType(double coverage, String type) {
		super();
		this.coverage = coverage;
		this.type = type;
	}

	public EventType(int id, double coverage, String type) {
		super();
		this.id = id;
		this.coverage = coverage;
		this.type = type;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Event_Type [id=" + id + ", coverage=" + coverage + ", type=" + type + "]";
	}
	
}
