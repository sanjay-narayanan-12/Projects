package com.sanjaynarayanan.jwt.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User controller
 * 
 * @author sanjay.narayanan
 * 
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

	/**
	 * get all user
	 * 
	 * @return
	 */

	@GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllUser() {
		return new ArrayList<>(Arrays.asList("Sanjay","Demo User"));
	}

}
