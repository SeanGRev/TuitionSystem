package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.dao.EventDAO;
import com.revature.dao.EventDAOImpl;
import com.revature.models.Event;
import com.revature.models.EventType;
import com.revature.models.GradeFormat;
import com.revature.services.EventService;
import com.revature.services.EventServiceImpl;

class EventTest {
	EventDAO evdao = new EventDAOImpl();
	EventService evs = new EventServiceImpl(evdao);
	
	
	// Event DAO Tests
	@Test
	void testDAOGetAllEvents() {
		assertNotNull(evdao.getAllEvents());
	}
	
	@Test
	void testDAOGetEventById() {
		Event ev = evdao.getEvent(1);
		assertEquals(ev.getId(), 1);
	}
	
	@Test
	void testDAOGetAllEventTypes() {
		assertNotNull(evdao.getAllEventTypes());
	}
	
	@Test
	void testDAOGetEventType() {
		EventType evt = evdao.getEventType(1);
		assertEquals(evt.getId(), 1);
	}
	
	@Test
	void testDAOGetAllGradeFormats() {
		assertNotNull(evdao.getAllGradeFormats());
	}
	
	@Test
	void testDAOGetGradeFormat() {
		GradeFormat gft = evdao.getGradeFormat(1);
		assertEquals(gft.getId(), 1);
	}
	
	// Event Service Tests
	@Test
	void testServiceGetAllEvents() {
		assertNotNull(evs.getAllEvents());
	}
	
	@Test
	void testServiceGetEventById() {
		Event ev = evs.getEvent(1);
		assertEquals(ev.getId(), 1);
	}
	
	@Test
	void testServiceGetAllEventTypes() {
		assertNotNull(evs.getAllEventTypes());
	}
	
	@Test
	void testServiceGetEventType() {
		EventType evt = evs.getEventType(1);
		assertEquals(evt.getId(), 1);
	}
	
	@Test
	void testServiceGetAllGradeFormats() {
		assertNotNull(evs.getAllGradeFormats());
	}
	
	@Test
	void testServiceGetGradeFormat() {
		GradeFormat gft = evs.getGradeFormat(1);
		assertEquals(gft.getId(), 1);
	}

}
