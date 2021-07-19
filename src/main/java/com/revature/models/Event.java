package com.revature.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
    
    @OneToOne
	@JoinColumn(name = "event_type_id")
	private EventType event_type;
    
    @OneToOne
	@JoinColumn(name = "grade_format_id")
	private GradeFormat grade_format;
    
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
	
	public Event(EventType event_type, GradeFormat grade_format, Date start_date, Date end_date, double tuition,
			String location, String description) {
		super();
		this.event_type = event_type;
		this.grade_format = grade_format;
		this.start_date = start_date;
		this.end_date = end_date;
		this.tuition = tuition;
		this.location = location;
		this.description = description;
	}

	public Event(int id, EventType event_type, GradeFormat grade_format, Date start_date, Date end_date, double tuition,
			String location, String description) {
		super();
		this.id = id;
		this.event_type = event_type;
		this.grade_format = grade_format;
		this.start_date = start_date;
		this.end_date = end_date;
		this.tuition = tuition;
		this.location = location;
		this.description = description;
	}

	public EventType getEvent_type() {
		return event_type;
	}

	public void setEvent_type(EventType event_type) {
		this.event_type = event_type;
	}

	public GradeFormat getGrade_format() {
		return grade_format;
	}

	public void setGrade_format(GradeFormat grade_format) {
		this.grade_format = grade_format;
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
		return "Event [id=" + id + ", event_type=" + event_type + ", grade_format=" + grade_format
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", tuition=" + tuition + ", location="
				+ location + ", description=" + description + "]";
	}
	
}
