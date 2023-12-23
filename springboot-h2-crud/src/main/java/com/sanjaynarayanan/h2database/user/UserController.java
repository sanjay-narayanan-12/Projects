package com.sanjaynarayanan.h2database.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@Autowired
	private UserService userService;

	/**
	 * get all user details
	 * 
	 * @return
	 */

	@GetMapping(value = "/userDetail", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserEntity> getAllUserDetails() {
		return userService.getAllUserDetail();
	}

	/**
	 * get user detail by user id
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "/userDetail/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUserDetailsById(@PathVariable Integer userId) {
		return userService.getUserByUserId(userId);
	}

	/**
	 * save user detail
	 * 
	 * @param userDetail
	 * @return
	 */
	@PostMapping(value = "/userDetail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUserDetails(@RequestBody UserEntity userDetail) {
		return userService.saveUser(userDetail);
	}

	/**
	 * update user detail by user id
	 * 
	 * @param userDetail
	 * @param userId
	 * @return
	 */
	@PutMapping(value = "/userDetail/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateUserDetails(@PathVariable Integer userId, @RequestBody UserEntity userDetail) {
		return userService.updateUser(userDetail, userId);
	}

	/**
	 * delete user detail by user id
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping(value = "/userDetail/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteUserDetails(@PathVariable Integer userId) {
		return userService.deleteUser(userId);
	}

}
