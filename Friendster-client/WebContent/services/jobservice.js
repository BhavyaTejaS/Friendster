/**
 * JobService
 */
app.factory('JobService',function($http){
	var jobService={}
	jobService.addJob=function(job){
		return $http.post("http://localhost:8087/Friendster-middleware/addjob",job)
	}
	jobService.getActiveJobs=function(job){
		return $http.get("http://localhost:8087/Friendster-middleware/activejobs")
	}
	jobService.getInActiveJobs=function(job){
		return $http.get("http://localhost:8087/Friendster-middleware/inactivejobs")
	}
	jobService.updateActiveStatus=function(job){
		return $http.put("http://localhost:8087/Friendster-middleware/updatejob",job)
	}
	return jobService;
})
	
