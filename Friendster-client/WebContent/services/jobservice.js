/**
 * JobService
 */
app.factory('JobService',function($http){
	var jobService={}
	jobService.addJob=function(job){
		return $http.post("http://localhost:8055/Friendster-middleware/addjob",job)
	}
	return jobService;
})
	
