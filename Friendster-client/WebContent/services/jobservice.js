/**
 * JobService
 */
app.factory('JobService',function($http){
	var jobService={}
	jobService.addJob=function(job){
		return $http.post("http://localhost:8055/Friendster-middleware/addjob",job)
	}
	jobService.getActiveJobs=function(job){
		return $http.get("http://localhost:8055/Friendster-middleware/activejobs")
	}
	jobService.getInActiveJobs=function(job){
		return $http.get("http://localhost:8055/Friendster-middleware/inactivejobs")
	}
	return jobService;
})
	
