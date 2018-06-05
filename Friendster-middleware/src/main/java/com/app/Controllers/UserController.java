package com.app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.DAO.UserDao;
import com.app.Models.User;

import com.app.Models.ErrorClazz;

@RestController
public class UserController {
	public UserController(){
		System.out.println("User Controller bean is created");
	}
	@Autowired
private UserDao userDao;
	@RequestMapping(value="/register",method=RequestMethod.POST)
public ResponseEntity<?> registration(@RequestBody User user){
    try{
    	if(!userDao.isEmailUnique(user.getEmail())){
    		ErrorClazz errorClazz=new ErrorClazz(2,"Email is already exists.....so enter different email");
    		return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.CONFLICT);
    	}
             userDao.registerUser(user);
         return new ResponseEntity<Void>(HttpStatus.OK);

}catch(Exception e){
	ErrorClazz errorClazz=new ErrorClazz(1,"Unable to register user details"+e.getMessage());
	return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
}
