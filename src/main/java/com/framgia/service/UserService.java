package com.framgia.service;

import java.util.List;

import com.framgia.model.User;

public interface UserService {
	List<User> getUsers(String username);

	User getUserById(Integer user_id);

	void addUser(User user);

	void deleteUser(Integer user_id);
	
	void updateUser(User user);
}
