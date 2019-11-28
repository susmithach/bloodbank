package com.cognizant.onlinebloodbank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.User;
import com.cognizant.onlinebloodbank.repository.DonateRepository;
import com.cognizant.onlinebloodbank.repository.UserRepository;

@RestController
@RequestMapping("/donate")
public class donateController {

	@Autowired
	DonateRepository donateRepository;
	@Autowired
	UserRepository userRepository;
	@PostMapping("/{id}")
	public void addDonor(@PathVariable String id,@RequestBody @Valid Donate donate)
	{
		User u=userRepository.findByUsername(id);
        u.setDonate(donate);	
		donate.setUserId(u);
		userRepository.save(u);
		donateRepository.save(donate);
	}
	@GetMapping
	public List<Donate> getAll()
	{
		return donateRepository.getAll();
		}
	
	
	
}
