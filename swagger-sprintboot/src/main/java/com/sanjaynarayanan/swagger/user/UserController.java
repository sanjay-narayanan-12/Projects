package com.sanjaynarayanan.swagger.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * User controller
 * 
 * @author sanjay.narayanan
 * 
 */
@Api(tags = "User", description = "User Detail")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	/**
	 * get all user details
	 * 
	 * @return
	 */
	@GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "This API is helps to get all users")
	public List<String> getAllUserDetails() {
		return new ArrayList<>(Arrays.asList("Sanjay", "Amy", "Young"));
	}

}
