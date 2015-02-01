package com.code.fox.chatterfox.data.provider;

import java.util.List;

import com.code.fox.chatterfox.data.AnonUser;
import com.code.fox.chatterfox.data.User;
import com.code.fox.chatterfox.data.UserMap;
//basic anonymous implementation of usermanager, listAllUsers not implemented yet
public class AnonManager implements UserManager {
	
	/** Retain AnonUsers while they're logged in */
	private static final UserMap userMap = new UserMap();

	@Override
	public boolean hasUser(String name)
	{
		return userMap.containsKey(name);
	}
	
	@Override
	public AnonUser getUser(String name) {
		return (AnonUser) userMap.get(name);
	}

	@Override
	public void updateUser(User user) {
		userMap.put(((AnonUser)user).getName(), user);
	}

	@Override
	public void deleteUser(String name) {
		userMap.remove(name);
	}

	@Override
	public List<User> listAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
