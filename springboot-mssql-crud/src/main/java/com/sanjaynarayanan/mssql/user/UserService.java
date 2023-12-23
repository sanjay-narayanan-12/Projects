package com.sanjaynarayanan.mssql.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

/**
 * User service
 * 
 * @author sanjay.narayanan
 */
public interface UserService {

	List<UserEntity> getAllUserDetail();
	
	ResponseEntity<Object> getUserByUserId(Integer userId);

	ResponseEntity<Object> saveUser(UserEntity userDetail);

	ResponseEntity<Object> updateUser(UserEntity userDetail, Integer userId);

	ResponseEntity<Object> deleteUser(Integer userId);

}
