package com.sanjaynarayanan.jwt.auth;

import lombok.Data;

/**
 * JWT request
 * 
 * @author sanjay.narayanan
 */
@Data
public class JwtRequest {

	private String username;

	private String password;

}
