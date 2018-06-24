package com.framgia.service;

import java.util.List;

import com.framgia.model.User;
import com.framgia.search.SearchUser;

public interface UserService {
	List<User> getUsers(SearchUser searchUser);

	User getUserById(Integer user_id);

	void addUser(User user);

	void deleteUser(Integer user_id);
	
	void updateUser(User user);
	
	Long countUser(SearchUser searchUser);
}
