package com.sanjaynarayanan.jwt.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JWT AUTH controller
 * 
 * @author sanjay.narayanan
 */
@RestController
@RequestMapping(value = "/api/v1")
public class JwtAuthController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtil util;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	/**
	 * get authentication by user name and password
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) throws Exception {
		authenticate(request.getUsername(), request.getPassword());
		UserDetails userDetails = jwtService.loadUserByUsername(request.getUsername());
		String token = util.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token, "Token generated successfully!"));
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
