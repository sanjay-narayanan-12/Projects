package com.sanjaynarayanan.jwt.auth;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service class for JWT with implements the spring security user detail service
 * 
 * @author sanjay.narayanan
 */
@Service
public class JwtService implements UserDetailsService {

	@Value("${Jwt.UserName}")
	public String name;

	@Value("${Jwt.Password}")
	public String password;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (name.equals(username)) {
			return new User(username, password, new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
