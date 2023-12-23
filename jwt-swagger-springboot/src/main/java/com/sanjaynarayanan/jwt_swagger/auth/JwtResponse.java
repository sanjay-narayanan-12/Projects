package com.sanjaynarayanan.jwt_swagger.auth;

import lombok.Data;

/**
 * JWT Response
 * 
 * @author sanjay.narayanan
 */
@Data
public class JwtResponse {

	private String token;

	private String message;

	public JwtResponse(String token, String message) {
		this.setToken(token);
		this.setMessage(message);
	}
}
