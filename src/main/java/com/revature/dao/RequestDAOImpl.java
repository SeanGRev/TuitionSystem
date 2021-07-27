package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Request;
import com.revature.util.HibernateUtil;

public class RequestDAOImpl implements RequestDAO{

	@Override
	public Request getRequest(int id) {
		Session sess = HibernateUtil.getSession();
		Request r = null;

		try {
			r = sess.get(Request.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return r;
	}
	
	@Override
	public List<Request> getAllRequests(){
		
		Session sess = HibernateUtil.getSession();
		List<Request> requests = null;
		
		try {
			requests = sess.createQuery("FROM Request").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return requests;
	}

	@Override
	public Request addRequest(Request req) {
		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			req.setId((int) sess.save(req));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			req = null;
		} finally {
			sess.close();
		}
		
		return req;
	}

	@Override
	public Request updateRequest(Request req) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.update(req);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return req;
	}
	
	
	
}
