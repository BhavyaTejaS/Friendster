package com.app.DAO;

import java.util.List;

import com.app.Models.BlogPost;

public interface BlogPostDao {
	void saveBlogPost(BlogPost blogPost);
List<BlogPost> approvedBlogs();
List<BlogPost> blogsWaitingForApproval();
BlogPost getBlogPost(int id);
}
