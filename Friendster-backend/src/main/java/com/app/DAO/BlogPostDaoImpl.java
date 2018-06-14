package com.app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Models.BlogPost;
@Repository
@Transactional


public class BlogPostDaoImpl implements BlogPostDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void saveBlogPost(BlogPost blogPost) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogPost);
	}

	public List<BlogPost> approvedBlogs() {
		Session session=sessionFactory.getCurrentSession();
		
		Query query=session.createQuery("from BlogPost where approved=true");
		return  query.list();//List of blogpost objects which are approved
	}

	public List<BlogPost> blogWaitingForApproval() {
Session session=sessionFactory.getCurrentSession();
		
		Query query=session.createQuery("from BlogPost where approved=false");
		return  query.list();
	}

}
