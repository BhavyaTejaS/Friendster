package com.app.testcase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.DAO.BlogPostDao;
import com.app.Models.BlogPost;
import com.app.Models.User;


public class BlogPostTestcase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static BlogPostDao blogPostDao;

	@Autowired
	static BlogPost blogPost;

	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.app");
		context.refresh();

		// get the productDAO from context
		blogPostDao = (BlogPostDao) context.getBean("blogPostDao");

	}

	
	@Test
	public void CreateJobTestCase() {
		blogPost = new BlogPost();

		blogPost.setBlogTitle("CSS2");
		blogPost.setBlogContent("The Latest version of CSS is CSS2");
		String s="admin@abc.com";
		User obj=new User();
		obj.setEmail(s);
		blogPost.setPostedBy(obj);
		
blogPost.setPostedOn(new java.util.Date());

		blogPostDao.saveBlogPost(blogPost);
		
		assertEquals(blogPost.getId(), blogPost.getId());

	}
}
