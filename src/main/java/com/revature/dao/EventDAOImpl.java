package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Event;
import com.revature.models.EventType;
import com.revature.models.GradeFormat;
import com.revature.util.HibernateUtil;

public class EventDAOImpl implements EventDAO {

	@Override
	public List<Event> getAllEvents() {
		
		Session sess = HibernateUtil.getSession();
		List<Event> events = null;
		try {
			events = sess.createQuery("FROM Event").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return events;
	}
	
	@Override
	public Event getEvent(int id) {
		Session sess = HibernateUtil.getSession();
		Event ev = null;

		try {
			ev = sess.get(Event.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return ev;
	}

	@Override
	public Event addEvent(Event ev) {
		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			ev.setId((int) sess.save(ev));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			ev = null;
		} finally {
			sess.close();
		}
		
		return ev;
	}

	@Override
	public EventType getEventType(int id) {
		Session sess = HibernateUtil.getSession();
		EventType evtype = null;
		
		try {
			evtype = sess.get(EventType.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return evtype;
	}

	@Override
	public GradeFormat getGradeFormat(int id) {
		Session sess = HibernateUtil.getSession();
		GradeFormat gformat = null;
		
		try {
			gformat = sess.get(GradeFormat.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return gformat;
	}

	@Override
	public List<EventType> getAllEventTypes() {
		Session sess = HibernateUtil.getSession();
		List<EventType> eTypes = null;
		try {
			eTypes = sess.createQuery("FROM EventType").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return eTypes;
	}

	@Override
	public List<GradeFormat> getAllGradeFormats() {
		Session sess = HibernateUtil.getSession();
		List<GradeFormat> gFormats = null;
		try {
			gFormats = sess.createQuery("FROM GradeFormat").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return gFormats;
	}
	
}
