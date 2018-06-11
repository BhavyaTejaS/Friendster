/**
 * JobCtrl
 */
app.controller('JobCtrl',function($scope,JobService,$location,$rootScope){
	$scope.addJob=function(job){
		JobService.addJob(job).then(
				function(response){
					alert('Job details inserted successfully')
					$location.path('/home')
				},function(response){
					//3 return statement for error in middleware
					$scope.error=response.data
					if($scope.error.errorCode==7){//not logged in
						$location.path('/login')
						$rootScope.error=response.data
					}
				})
		}
	function getActiveJobs(){
		JobService.getActiveJobs().then(function(response){
			$scope.activeJobs=response.data
			
		},function(response){
			
		$scope.error=response.data
		if(response.status==401)
		$location.path('/login')
		})
	}
	function getInActiveJobs(){
		JobService.getInActiveJobs().then(function(response){
			//response.data is array of inactive jobs
			$scope.inActiveJobs=response.data
			
		},function(response){
			$scope.error=response.data 
			if(response.data.errorcode==7)
				$location.path('/login')
		})
	}
	getActiveJobs()
	if($rootScope.loggedInUser.role=='ADMIN')
		getInActiveJobs()
	
})