package com.cognizant.onlinebloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.onlinebloodbank.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
