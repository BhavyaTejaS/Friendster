package com.app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Models.Friend;
import com.app.Models.User;
@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<User> getSuggestedUsers(String email) {
		Session session=sessionFactory.getCurrentSession();
	
		SQLQuery query=session.createSQLQuery("select * from USER_DB where email in"
				+ "(select email from USER_DB where email!=?"
						+ " minus "
						+"(select toId_email from FRIEND_S180396 where fromId_email=? " 
						+" union "
						+"select fromId_email from FRIEND_S180396 where toId_email=? "
						+ ")"
						+")");
		query.setString(0, email);
		query.setString(1, email);
		query.setString(2, email);
		query.addEntity(User.class);
		List<User> suggestedUsers=query.list();
		return suggestedUsers;
	}
	public void addFriend(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
	}

}