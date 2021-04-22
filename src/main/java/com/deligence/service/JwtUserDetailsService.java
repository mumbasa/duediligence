package com.deligence.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		com.deligence.models.User user = userRepo.findUserByEmail(username);

		if (user !=null){

			User u = new User(user.getEmail(), user.getPassword(), new ArrayList<GrantedAuthority>());
			return u;

		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}



}
