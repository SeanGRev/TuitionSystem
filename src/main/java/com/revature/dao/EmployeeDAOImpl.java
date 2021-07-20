package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.app.App;
import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Override
	public List<Employee> getAllEmployees() {
		
		Session sess = HibernateUtil.getSession();
		List<Employee> employees = null;
		
		try {
			employees = sess.createQuery("FROM Employee").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return employees;
	}
	
	@Override
	public Employee getEmployee(int id) {
		Session sess = HibernateUtil.getSession();
		Employee em = null;

		try {
			em = sess.get(Employee.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return em;
	}

	@Override
	public Employee addEmployee(Employee em) {
		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			em.setId((int) sess.save(em));
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
			em = null;
		} finally {
			sess.close();
		}

		return em;
	}
	
	
	
}
