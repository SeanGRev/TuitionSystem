package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Event;
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
	
}
