package com.app.Controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.DAO.JobDao;
import com.app.DAO.UserDao;
import com.app.Models.ErrorClazz;
import com.app.Models.Job;
import com.app.Models.User;

@RestController
public class JobController {
	
	public JobController(){
		System.out.println("JobController bean is created");
	}
	
	@Autowired
private JobDao jobDao;
	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/addjob",method=RequestMethod.POST)
	public ResponseEntity<?> saveJob(@RequestBody Job job,HttpSession session){
		//Authentication & Authorization
		//Authentication-who u are?
		//Authorization-role..
		String email=(String)session.getAttribute("email");
		if(email==null){//not logged in
			ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access..please login");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
			
		}
		
	//if email !=null user is authenticated user
	//check user is authorized to insert new job or not.Check the role of the user
		//check if logged in user is admin or not
		User user=userDao.getUser(email);
		if(!user.getRole().equals("ADMIN")){
			ErrorClazz errorClazz=new ErrorClazz(8,"Access Denined.......");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		//Authentication and authorization for new job details
		try{
			job.setPostedOn(new Date());
			job.setActive(true);//job position is still available
		jobDao.saveJob(job);
		return new ResponseEntity<Void>(HttpStatus.OK);//Only Http Status code is returned, Http Response Body is empty
        //response.status =200, response.data=""

		}catch(Exception e){
			ErrorClazz errorClazz=new ErrorClazz(4,"Unable to insert the job details.."+e.getMessage());
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value="/activejobs",method=RequestMethod.GET)
	public ResponseEntity<?> getActiveJobs(HttpSession session){//Authentication
		String email=(String)session.getAttribute("email");
		if(email==null){
		ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access..please login");
	return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
	}
		
		List<Job> activeJobs=jobDao.getActiveJobs();
		return new ResponseEntity<List<Job>>(activeJobs,HttpStatus.OK);
	}
	@RequestMapping(value="/inactivejobs",method=RequestMethod.GET)
	public ResponseEntity<?> getInActiveJobs(HttpSession session){//Authentication and Authorization
String email=(String)session.getAttribute("email");
		if(email==null){
		ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access..please login");
		return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);

	}
		
		User user=userDao.getUser(email);
		if(!user.getRole().equals("ADMIN")){
			ErrorClazz errorClazz=new ErrorClazz(8,"Access Denined.......");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		List<Job> inactiveJobs=jobDao.getInActiveJobs();
		return new ResponseEntity<List<Job>>(inactiveJobs,HttpStatus.OK);
	}
	@RequestMapping(value="/updatejob",method=RequestMethod.PUT)
public ResponseEntity<?> updateJob(HttpSession session,@RequestBody Job job){//job with updated active value
	String email=(String)session.getAttribute("email");
	if(email==null){
	ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access..please login");
	return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);

}
	
	User user=userDao.getUser(email);
	if(!user.getRole().equals("ADMIN")){
		ErrorClazz errorClazz=new ErrorClazz(8,"Access Denined.......");
		return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
	}
	jobDao.updateJob(job);
	return new ResponseEntity<Void>(HttpStatus.OK);
	
}
	
}
