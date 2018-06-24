package com.framgia.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;
import com.framgia.search.SearchUser;
import com.framgia.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<User> getUsers(SearchUser searchUser) {
		int totalPage = (int) Math.ceil(countUser(searchUser) / (double) searchUser.getPageSize());
		searchUser.setTotalPage(totalPage > 0 ? totalPage : 0);
		try {
			
			return getUserDAO().getUsers(searchUser);
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

	@Override
	public Long countUser(SearchUser searchUser) {
		// TODO Auto-generated method stub
		return getUserDAO().countUser(searchUser);
	}
	
	

}
