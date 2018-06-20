package com.app.DAO;

import com.app.Models.BlogPost;
import com.app.Models.BlogPostLikes;

public interface BlogPostLikesDao {
BlogPostLikes hasUserLikedBlogPost(int blogpostId,String email);

BlogPost updateBlogPostLikes(int blogPostId, String email);


}
