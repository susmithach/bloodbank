package com.cognizant.onlinebloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.onlinebloodbank.model.Donate;

public interface DonateRepository extends JpaRepository<Donate, Integer>{
	@Query("SELECT u from Donate u")
	List<Donate> getAll();

}
