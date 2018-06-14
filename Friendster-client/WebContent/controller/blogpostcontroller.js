/**
 * BlogCtrl
 */
app.controller('BlogCtrl',function($scope,BlogService,$location,$rootScope){
	$scope.addBlog=function(blog){
		BlogService.addBlog(blog).then(function(response){
			alert('Blogpost has been inserted successfully...It is waiting for approval')
			$location.path('/home')
		},function(response){
			$rootScope.error=response.data
			if(response.status==401)
				$location.path('/login')
		})
		function blogsApproved(){
			BlogService.blogApproved().then(function(response){
				//response.data
				$scope.blogsApproved=response.data
			},function(response){
				if(response.status==401)
					$location.path('/login')
				
			})
		}
		function blogsWaitingForApproval(){
			BlogService.blogApproved().then(function(response){
				//response.data
				$scope.blogWaitingForApproval=response.data
			},function(response){
				if(response.status==401)
					$location.path('/login')
				
			})
			
		}
		blogsApproved()
		if($rootScope.loggedInUser.role=='ADMIN')
		
		blogsWaitingForApproval()
		
	}
	
	
	
})