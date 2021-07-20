package com.revature.dao;

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
	
}
