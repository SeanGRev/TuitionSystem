package com.revature.models;

public class EventID {

	private int id;
    
	private int event_type_id;
    
	private int grade_format_id;
    
	private String start_date;
    
	private String end_date;
    
	private double tuition;
    
	private String location;
    
	private String description;

	public EventID(int event_type_id, int grade_format_id, String start_date, String end_date, double tuition,
			String location, String description) {
		super();
		this.event_type_id = event_type_id;
		this.grade_format_id = grade_format_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.tuition = tuition;
		this.location = location;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
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
	
}
