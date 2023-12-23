package com.sanjaynarayanan.jwt_swagger.auth;

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
