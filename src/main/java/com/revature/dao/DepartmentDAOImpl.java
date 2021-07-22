package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Department;
import com.revature.util.HibernateUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public Department getDepartment(int id) {
		Session sess = HibernateUtil.getSession();
		
		Department d = null;
		
		try {
			d = sess.get(Department.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return d;
	}

	@Override
	public List<Department> getAllDepartments() {
		Session sess = HibernateUtil.getSession();
		List<Department> departments = null;
		
		try {
			departments = sess.createQuery("FROM Department").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return departments;
	}
	
	
	
}
