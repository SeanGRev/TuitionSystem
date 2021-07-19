package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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

	
	
}
