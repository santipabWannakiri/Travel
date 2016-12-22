package com.tra.config.login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tra.persistence.User;

@Service
public class UserDetailServices implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String UserName) throws UsernameNotFoundException {
		User user = new User();
		System.out.println("try login by user name => " + UserName);
		
		if(UserName == null ){
            throw new UsernameNotFoundException("User " + UserName + " not found!");
        }
        return new UserDetaislApp(user);
	}
	
	

}
