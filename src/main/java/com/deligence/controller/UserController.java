package com.deligence.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deligence.configuration.JwtTokenUtil;
import com.deligence.models.User;
import com.deligence.service.JwtUserDetailsService;
import com.deligence.service.UserService;

@RestController
@RequestMapping("/v1/api")
public class UserController {

	@Autowired
	UserService userService;
	
	

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@GetMapping("/add/user")
	public User saveUser(@RequestBody User authenticationRequest) {
		return userService.save(authenticationRequest);
		
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.listAll();
		
	}
	
	@GetMapping("/users/")
	public List<User> getUsesrs(@RequestBody Date date) {
		return userService.findUserByDate(date);
		
	}
	
	@GetMapping("/users/email")
	public User getUsersByemai() {
		return userService.findUserByEmail("brya");
		
	}
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		User user = userService.findUserByEmail(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);
		user.setToken(token);
		return ResponseEntity.ok(user);
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
