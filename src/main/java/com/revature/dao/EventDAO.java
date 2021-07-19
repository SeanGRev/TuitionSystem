package com.revature.dao;

import java.util.List;

import com.revature.models.Event;

public interface EventDAO {

	public Event getEvent(int id);

	List<Event> getAllEvents();
	
}
