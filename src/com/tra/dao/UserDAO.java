package com.tra.dao;


import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.tra.model.UserModel;
import com.tra.persistence.Role;
import com.tra.persistence.User;

@Named
@Transactional("transactionManager")
public class UserDAO {
	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(UserModel model) {
		User user = new User();
		user.setLogin(model.getLogin());
		user.setPwd(model.getPwd());
		user.setEnabled(1);
		
		Role role = new Role();
		role.setCode("ROLE_USER");
		role.setLabel("ROLE FOR SIMPLE ACCESS");
		role.setUser(user);
		
		user.getRoles().add(role);
		
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().save(role);
		System.out.println("Register successfuly !!");
	}
	
}
