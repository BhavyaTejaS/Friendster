package com.app.testcase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.DAO.JobDao;
import com.app.DAO.UserDao;
import com.app.Models.Job;
import com.app.Models.User;

public class JobTestcase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static JobDao jobDao;


	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.app");
		context.refresh();

		// get the productDAO from context
		jobDao = (JobDao) context.getBean("jobDao");

	}

	@Ignore
	@Test
	public void CreateJobTestCase() {
		Job job = new Job();

		job.setJobTitle("DataBase Operation");
		job.setJobDescription("backend operation");
		job.setLocation("Hyderabad");
		job.setSalary("15k-22k");
		job.setSkillsRequried("basic knowledge on SQL");
		job.setYrsofExp("Fresher");
		jobDao.saveJob(job);
		assertEquals(job.getId(), job.getId());

	}

}
