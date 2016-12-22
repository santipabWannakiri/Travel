package com.tra.config.login;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.tra.persistence.User;

public class UserDetaislApp implements UserDetails {
	public static final GrantedAuthority ADMIN_ROLE = new SimpleGrantedAuthority("ADMIN");
	public static final GrantedAuthority ROLE_USER = new SimpleGrantedAuthority("USER");
	private User user;
	private Set<GrantedAuthority> grants;

	// Auto-generated constructor stub
	public UserDetaislApp(User user) {
		this.user = user;
	}

	// Check and enable permisstion
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (grants == null) {
			grants = new HashSet<GrantedAuthority>();
			switch (user.getLogin()) {
			case "admin":
				grants.add(ADMIN_ROLE);
				grants.add(ROLE_USER);
				break;

			default:
				grants.add(ROLE_USER);
				break;
			}
		}
		return grants;
	}

	@Override
	public String getPassword() {
		return user.getPwd();
	}

	@Override
	public String getUsername() {
		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
