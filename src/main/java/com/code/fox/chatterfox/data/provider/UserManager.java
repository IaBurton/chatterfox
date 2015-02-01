package com.code.fox.chatterfox.data.provider;

import java.util.List;

import com.code.fox.chatterfox.data.User;
//mostly bumped from demo-web-project with addition of hasUser
public interface UserManager {
	
	public boolean hasUser(String name);

	/**
	 * Get the user information object based on
	 * the given userId.
	 * <p>
	 * If the user does not exist, simply create
	 * one.
	 *
	 * @param name
	 * @return the User object
	 */
	public User getUser(String name);

	/**
	 * Update the given user object and persist it.
	 * <p>
	 * If the user does not exist before, this
	 * method will create a new record; otherwise,
	 * it will overwrite whatever is currently
	 * being stored.
	 *
	 * @param user object
	 */
	public void updateUser(User user);

	/**
	 * Delete the given user from the storage.
	 *
	 * @param name
	 */
	public void deleteUser(String name);

	/**
	 * List all the current users in the storage.
	 *
	 * @return
	 */
	public List<User> listAllUsers();

}
