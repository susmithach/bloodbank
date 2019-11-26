package com.cognizant.onlinebloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.onlinebloodbank.model.Request;


public interface RequestRepository extends JpaRepository<Request, Integer> {
	 @Query("SELECT u from Request u")
	    List<Request> getAll();
}
