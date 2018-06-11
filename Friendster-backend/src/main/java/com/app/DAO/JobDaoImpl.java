package com.app.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Models.Job; 
@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao {
	@Autowired
private SessionFactory sessionFactory;
	public void saveJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
	}
	//jobs which are avialable
	public List<Job> getActiveJobs() {
		Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Job where active=true");
	return query.list();//return list of active jobs
			
	}
	//No vacancies for the job position
	public List<Job> getInActiveJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Job where active=false");
		return query.list();
	}
	
}
