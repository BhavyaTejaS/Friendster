package com.app.testcase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.DAO.UserDao;
import com.app.Models.User;

public class UserTestcase{

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDao userDao;

	@Autowired
	static User user;

	
	
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.app");
		context.refresh();
		
		//get the productDAO from context
		userDao =  (UserDao) context.getBean("userDao");
		
			
	
	}
	@Ignore
	@Test
	public void createUserTestCase()
	{
		User user=new User();
		

		
		user.setFirstname("srihari");
		user.setLastname("sri");
		user.setEmail("srihari@gmail.com");
		user.setPassword("srihari");
		user.setPhonenumber("999789756");
		
		userDao.registration(user);
		assertEquals(user.getEmail(),user.getEmail());
		
	
	}
	
	@Ignore
	@Test
	public void uniqueEmailIdTest()
	{
		
		User user=new User();
user.setEmail("niit.s@abc.com");
		boolean status=userDao.isEmailUnique(user.getEmail());
		
		assertEquals("unique email id failure", false, status);
	}
	@Test
	public void getUserDetails()
	{
		
		String userEmail = "srihari@gmail.com";

               user=new User();

		 user = userDao.getUser(userEmail);
		 System.out.println("\n First Name "+user.getFirstname());
		 System.out.println("\n Last Name "+user.getLastname());
		 
		assertEquals(userEmail, userDao.getUser(userEmail));
		

	}	
}
