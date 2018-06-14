/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:8055/Friendster-middleware/addblogpost",blog)
		
	}
	blogService.blogsApproved=function(){
		return $http.get("http://localhost:8055/Friendster-middleware/blogsapproved")
		
	}
	blogService.blogswaitingforapproval=function(){
		return $http.get("http://localhost:8055/Friendster-middleware/blogswaitingforapproval")
		
	}
	
	return blogService;
})