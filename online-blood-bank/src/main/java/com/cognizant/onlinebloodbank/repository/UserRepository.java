package com.cognizant.onlinebloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cognizant.onlinebloodbank.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User u where u.username=?1" )
    User findByUsername(String username);

	 @Query("SELECT u from User u")
	    List<User> getUsers();
}
