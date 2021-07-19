package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	
}
