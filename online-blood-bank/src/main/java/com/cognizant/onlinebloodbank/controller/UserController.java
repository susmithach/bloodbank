package com.cognizant.onlinebloodbank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.onlinebloodbank.model.User;
import com.cognizant.onlinebloodbank.service.AppUserDetailsService;



@RestController

@RequestMapping("/users")
public class UserController {
	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;
	@Autowired
	private AppUserDetailsService appuserdetailsservice;
//	@PostMapping
//	public boolean signup(@RequestBody @Valid Users user) throws UserAlreadyExistsException
//	{
//		if(inMemoryUserDetailsManager.userExists(user.getUsername())){
//			return false;
//		}
//		else{
//			inMemoryUserDetailsManager.createUser(User.withUsername(user.getUsername())
//	            .password(new BCryptPasswordEncoder()
//	            .encode(user.getPassword()))
//	            .roles("USER").build());
//			return true;
//		}
//	}
	@GetMapping()
	public List<User> userlist()
	{
		return appuserdetailsservice.userlist();
	}
	@PostMapping
	public boolean signup(@RequestBody @Valid User user) 
	{

			return appuserdetailsservice.signup(user);
		
	}
	
	
	
	

}


