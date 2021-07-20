package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Attachment;
import com.revature.models.Presentation;
import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public Reimbursement getReimbursement(int id) {
		Session sess = HibernateUtil.getSession();
		Reimbursement r = null;
		
		try {
			r = sess.get(Reimbursement.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return r;
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		Session sess = HibernateUtil.getSession();
		List<Reimbursement> reimbursements = null;
		
		try {
			reimbursements = sess.createQuery("FROM Reimbursement").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return reimbursements;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement rei) {
		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			rei.setId((int) sess.save(rei));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			rei = null;
		} finally {
			sess.close();
		}
		
		return rei;
	}

	@Override
	public List<Attachment> getAllAttachments() {
		Session sess = HibernateUtil.getSession();
		List<Attachment> attachments = null;
		
		try {
			attachments = sess.createQuery("FROM Attachment").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return attachments;
	}

	@Override
	public List<Presentation> getAllPresentations() {
		Session sess = HibernateUtil.getSession();
		List<Presentation> presentations = null;
		
		try {
			presentations = sess.createQuery("FROM Presentation").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return presentations;
	}
	
}
