package com.revature.controllers;

import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.revature.models.CommandJson;
import com.revature.models.Event;
import com.revature.models.EventID;
import com.revature.models.EventType;
import com.revature.models.GradeFormat;
import com.revature.services.EventService;

import io.javalin.http.Handler;

public class EventController {

	EventService es;
	Gson gson = new Gson();
	
	public EventController(EventService es) {
		this.es = es;
	}
	
	public Handler getAllEvents = (ctx) ->{
		List<Event> events = es.getAllEvents();
		
		if(events != null) {
			ctx.result(gson.toJson(events));
		} else {
			ctx.result("[]");
		}
	};
	
	public Handler getEventById = (ctx) -> {
		String input = ctx.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Event ev = es.getEvent(id);
		
		if(ev != null) {
			ctx.result(gson.toJson(ev));
		} else {
			ctx.result("[]");
		}
	};
	
	public Handler addEvent = (ctx) -> {
		EventID eid = gson.fromJson(ctx.body(), EventID.class);
		
		EventType eventType = es.getEventType(eid.getEvent_type_id());
		GradeFormat gradeFormat = es.getGradeFormat(eid.getGrade_format_id());
		
		Event ev = new Event(eventType, gradeFormat, LocalDate.parse(eid.getStart_date()), LocalDate.parse(eid.getEnd_date()), eid.getTuition(),
				eid.getLocation(), eid.getDescription());
		
		ev = es.addEvent(ev);
		if(ev != null) {
			ctx.result(gson.toJson(ev));
		} else {
			ctx.status(400);
		}
	};
	
	
}
