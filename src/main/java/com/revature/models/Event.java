package com.revature.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
    
    @Column(name="event_type_id", nullable = false)
	private int event_type_id;
    
    @Column(name = "grade_format_id", nullable = false)
	private int grade_format_id;
    
    @Column(name="start_date", nullable = false)
	private Date start_date;
    
    @Column(name="end_date", nullable = true)
	private Date end_date;
    
    @Column(name="tuition", nullable = false)
	private double tuition;
    
    @Column(name="location", nullable = false)
	private String location;
    
    @Column(name="description", nullable = false)
	private String description;
	
	public Event() {
		super();
	}
	
	public Event(int event_type_id, int grade_format_id, Date start_date, Date end_date, double tuition, String location,
			String description) {
		super();
		this.event_type_id = event_type_id;
		this.grade_format_id = grade_format_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.tuition = tuition;
		this.location = location;
		this.description = description;
	}

	public Event(int id, int event_type_id, int grade_format_id, Date start_date, Date end_date, double tuition,
			String location, String description) {
		super();
		this.id = id;
		this.event_type_id = event_type_id;
		this.grade_format_id = grade_format_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.tuition = tuition;
		this.location = location;
		this.description = description;
	}

	public int getEvent_type_id() {
		return event_type_id;
	}

	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}

	public int getGrade_format_id() {
		return grade_format_id;
	}

	public void setGrade_format_id(int grade_format_id) {
		this.grade_format_id = grade_format_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public double getTuition() {
		return tuition;
	}

	public void setTuition(double tuition) {
		this.tuition = tuition;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", event_type_id=" + event_type_id + ", grade_format_id=" + grade_format_id
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", tuition=" + tuition + ", location="
				+ location + ", description=" + description + "]";
	}
	
}
