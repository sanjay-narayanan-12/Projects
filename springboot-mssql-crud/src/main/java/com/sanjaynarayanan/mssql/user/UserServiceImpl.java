package com.sanjaynarayanan.mssql.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 
 * Service Implement for user
 * 
 * @author sanjay.narayanan
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	/**
	 * get all user details
	 * 
	 * @return
	 */
	@Override
	public List<UserEntity> getAllUserDetail() {
		return userRepo.findAll();
	}

	/**
	 * get user details by user id
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public ResponseEntity<Object> getUserByUserId(Integer userId) {
		return userRepo.findById(userId).map(userDetail -> {
			return ResponseEntity.status(HttpStatus.OK).body((Object) userDetail);
		}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body((Object) "User detail not found"));
	}

	/**
	 * save user detail
	 * 
	 * @param userDetail
	 * @return
	 */
	@Override
	public ResponseEntity<Object> saveUser(UserEntity userDetail) {
		userDetail = userRepo.save(userDetail);
		return ResponseEntity.status(HttpStatus.OK).body(userDetail);
	}

	/**
	 * update user detail by user id
	 * 
	 * @param userDetail
	 * @param userId
	 * @return
	 */
	@Override
	public ResponseEntity<Object> updateUser(UserEntity userDetail, Integer userId) {
		return userRepo.findById(userId).map(userEntity -> {
			userEntity = userRepo.save(userEntity);
			return ResponseEntity.status(HttpStatus.OK).body((Object) userEntity);
		}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("User detail not found"));
	}

	/**
	 * delete user detail by user id
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public ResponseEntity<Object> deleteUser(Integer userId) {
		return userRepo.findById(userId).map(userDetail -> {
			userRepo.delete(userDetail);
			return ResponseEntity.status(HttpStatus.OK).body((Object) "User detail deleted successfully");
		}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body((Object) "User detail not found"));
	}
}
