package com.app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Models.User;
@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<User> getSuggestedUsers(String email) {
		Session session=sessionFactory.getCurrentSession();
	
		SQLQuery query=session.createSQLQuery("");
		return null;
	}

}
