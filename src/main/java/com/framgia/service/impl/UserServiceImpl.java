package com.framgia.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;
import com.framgia.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<User> getUsers(String username) {
		try {
			return getUserDAO().getUsers(username);
		} catch (Exception e) {
			throw e;
		}
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public User getUserById(Integer user_id) {
		
		return getUserDAO().getUserById(user_id);
	}

	@Override
	@Transactional
	public void addUser(User user) {
		getUserDAO().addUser(user);
		
	}

	@Override
	@Transactional
	public void deleteUser(Integer user_id) {
		// TODO Auto-generated method stub
		getUserDAO().deleteUser(user_id);
		
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		getUserDAO().updateUser(user);
		
	}
	
	

}
