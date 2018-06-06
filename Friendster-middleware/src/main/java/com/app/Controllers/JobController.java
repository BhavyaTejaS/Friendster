package com.app.Controllers;

import java.util.Date;

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
	@Autowired
private JobDao jobDao;
	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/addjob",method=RequestMethod.POST)
	public ResponseEntity<?> saveJob(@RequestBody Job job,HttpSession session){
		//Authentication & Authorization
		//Authentication-who u are?
		//Authoriztion-role..
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
}
