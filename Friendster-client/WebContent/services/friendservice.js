/**
 * 
 */
app.factory('FriendService',function($http){
	var friendService={}
	
	
	friendService.getSuggestedUsers=function(){
		return $http.get("http://localhost:8087/Friendster-middleware/suggestedusers")
		
	}
	friendService.sendFriendRequest=function(toIdValue){
		return $http.post("http://localhost:8087/Friendster-middleware/addfriend",toIdValue)
		
	}
	return friendService;
})