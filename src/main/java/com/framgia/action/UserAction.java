package com.framgia.action;

import java.util.List;

import com.framgia.model.User;
import com.framgia.search.SearchUser;
import com.framgia.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	private List<User> users;

	private User user;

	private Integer id;
	
	private String searchKeyword;
	
	

	public String homePage() { 
		SearchUser searchUser=new SearchUser();
		searchUser.setKeyword(getSearchKeyword());
		users = userService.getUsers(searchUser);
		return SUCCESS;
	}

	public String saveOrUpdateUser() {
		if(user.getId()==null){
			userService.addUser(user);
		}
		else{
			userService.updateUser(user);
		}
		
		return SUCCESS;
	}
	
	public String newUser() {

		if (getId()!=null) {
            user = userService.getUserById(getId());
        }
		return SUCCESS;
	}

	public String deleteUser() {
		userService.deleteUser(getId());
		return SUCCESS;
	}

	public String getUserById() {

		user = userService.getUserById(getId());
		return SUCCESS;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	

	
	
	

}