/**
 * Angular JS Module
 */
var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/registration',{
		controller:'UserCtrl',
		templateUrl:'view/registrationform.html'
	})
	.when('/home',{
		templateUrl:'view/home.html'
	})
	.when('/login',{
		controller:'UserCtrl',
		templateUrl:'view/login.html'
	})
	
	.when('/updateprofile',{
		controller:'UserCtrl',
		templateUrl:'view/updateprofile.html' //user object in updateprofile.html
	})
	
	.when('/addjob',{//v to c
		controller:'JobCtrl',
		templateUrl:'view/jobform.html' 
	})
	.when('/activejobs',{
		controller:'JobCtrl',
		templateUrl:'view/activejobslist.html' 
	})
	.when('/inactivejobs',{
		controller:'JobCtrl',
		templateUrl:'view/inactivejobslist.html' 
	})
	.when('/addblog',{
		controller:'BlogCtrl',
		templateUrl:'view/blogform.html' 
	})
	.when('/blogsapproved',{
		controller:'BlogCtrl',
		templateUrl:'view/blogsapproved.html' 
	})
	.when('/blogswaitingforapproval',{
		controller:'BlogCtrl',
		templateUrl:'view/blogswaitingforapproval.html' 
	})
	.when('/getblogapproved/:id',{
		controller:'BlogInDetailCtrl',
		templateUrl:'view/blogindetail.html' 
	})
	.when('/getblogwaitingforapproval/:id',{
		controller:'BlogInDetailCtrl',
		templateUrl:'view/blogapprovalform.html' 
	})
	
	
	.otherwise({  
		templateUrl:'view/home.html'
	})
 })
app.run(function($rootScope,$cookieStore,UserService,$location){
	if($rootScope.loggedInUser==undefined)
		$rootScope.loggedInUser=$cookieStore.get('loggedInUser')
		
		$rootScope.logout=function(){
		alert('Entering logout')
		UserService.logout().then(function(response){
			$rootScope.message="Loggedout successfully..."
				delete $rootScope.loggedInUser
				$cookieStore.remove('loggedInUser')
			$location.path('/login')
		},function(response){
			$rootScope.error=response.data //ErrorClazz object returned from middleware
			$location.path('/login')
		})
	}	
})




