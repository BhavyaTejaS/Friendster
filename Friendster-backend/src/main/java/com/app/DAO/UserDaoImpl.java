package com.app.DAO;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Models.User;
@Repository
@Transactional

public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	private String email;
	public void registration(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
	


	}
	public boolean isEmailUnique(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=?");
		query.setString(0,email);
		User user=(User)query.uniqueResult();
		if(user!=null)
	return false;
		else 
			return true;
	}
		
	
}
