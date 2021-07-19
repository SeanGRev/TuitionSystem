package com.revature.services;

import java.util.List;

import com.revature.models.Event;

public interface EventService {

	public Event getEvent(int id);
	
	public List<Event> getAllEvents();
	
}
