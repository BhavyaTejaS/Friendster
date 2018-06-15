/**
 * BlogInDetailCtrl
 */
app.controller('BlogInDetailCtrl',function($scope,$location,BlogService,$rootScope,$routeParams){
	
	var id=$routeParams.id
	BlogService.getBlogPost(id).then(function(response){
		$scope.blogPost=response.data
	},function(response){
		$scope.error==response.data
		if(response.status==401)
			$location.path('/login')

	})
	$scope.approved=function(blogPost){
		blogPost.approved=true
		BlogService.updateApprovalStatus(blogPost)
	}
	$scope.reject=function(blogPost){
		
		blogPost.approved=false
		BlogService.updateApprovalStatus(blogPost)
		
	}
})