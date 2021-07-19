package com.revature.services;

import java.util.List;

import com.revature.dao.EventDAO;
import com.revature.models.Event;

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
	
}
