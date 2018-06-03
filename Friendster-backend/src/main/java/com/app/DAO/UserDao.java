package com.app.DAO;

import com.app.Models.User;

public interface UserDao {

void registration(User user);
		boolean isEmailUnique(String email);
		
	}

