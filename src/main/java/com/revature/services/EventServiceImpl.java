package com.revature.services;

import java.util.List;

import com.revature.dao.EventDAO;
import com.revature.models.Event;
import com.revature.models.EventType;
import com.revature.models.GradeFormat;

public class EventServiceImpl implements EventService{

	public EventDAO edao;
	
	public EventServiceImpl(EventDAO edao) {
		this.edao = edao;
	}

	@Override
	public Event getEvent(int id) {
		return edao.getEvent(id);
	}

	@Override
	public List<Event> getAllEvents() {
		return edao.getAllEvents();
	}
	
	@Override
	public Event addEvent(Event ev) {
		return edao.addEvent(ev);
	}

	@Override
	public EventType getEventType(int id) {
		return edao.getEventType(id);
	}

	@Override
	public GradeFormat getGradeFormat(int id) {
		return edao.getGradeFormat(id);
	}
	
}
