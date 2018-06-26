package com.app.DAO;

import java.util.List;

import com.app.Models.Friend;
import com.app.Models.User;

public interface FriendDao {
	List<User> getSuggestedUsers(String email);

	void addFriend(Friend friend);

	
}
