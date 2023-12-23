package com.sanjaynarayanan.mysql.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository
 * 
 * @author sanjay.narayanan
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
