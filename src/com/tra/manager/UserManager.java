package com.tra.manager;

import javax.inject.Inject;
import javax.inject.Named;

import com.tra.dao.UserDAO;
import com.tra.model.UserModel;



@Named
public class UserManager {

	@Inject
	public UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(UserModel model) {
		userDAO.addUser(model);
	}
}
