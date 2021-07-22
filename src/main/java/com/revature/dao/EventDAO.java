package com.revature.dao;

import java.util.List;

import com.revature.models.Event;
import com.revature.models.EventType;
import com.revature.models.GradeFormat;

public interface EventDAO {

	public Event getEvent(int id);

	List<Event> getAllEvents();
	
	public Event addEvent(Event ev);
	
	public EventType getEventType(int id);
	
	public List<EventType> getAllEventTypes();
	
	public GradeFormat getGradeFormat(int id);
	
	public List<GradeFormat> getAllGradeFormats();
	
}
