/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:8087/Friendster-middleware/addblogpost",blog)
		
	}
	blogService.blogsApproved=function(){
		return $http.get("http://localhost:8087/Friendster-middleware/blogsapproved")
		
	}
	blogService.blogsWaitingForApproval=function(){
		return $http.get("http://localhost:8087/Friendster-middleware/blogswaitingforapproval")
		
	}
	blogService.getBlogPost=function(id){
		return $http.get("http://localhost:8087/Friendster-middleware/getblogpost/"+id)
	}
	blogService.updateApprovalStatus=function(blogPost){
		return $http.put("http://localhost:8087/Friendster-middleware/updatestatusapproval",blogPost)
	}
	blogService.hasUserLikedBlog=function(blogpostId){
		return $http.get("http://localhost:8087/Friendster-middleware/hasuserlikedblog/"+blogpostId)
	}
	blogService.updateBlogPostLikes=function(blogPostId){
		return $http.put("http://localhost:8087/Friendster-middleware/updateblogpostlikes/"+blogPostId)
	}
	return blogService;
}) 