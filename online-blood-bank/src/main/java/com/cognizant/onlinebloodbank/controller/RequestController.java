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

import com.cognizant.onlinebloodbank.model.Request;
import com.cognizant.onlinebloodbank.model.User;
import com.cognizant.onlinebloodbank.repository.RequestRepository;
import com.cognizant.onlinebloodbank.repository.UserRepository;
import com.cognizant.onlinebloodbank.service.RequestService;

@RestController
@RequestMapping("/request")
public class RequestController {
@Autowired
RequestService requestService;
@Autowired 
UserRepository userRepository;
@Autowired
RequestRepository requestRepository;
@PostMapping("/{id}")
public void addRequest(@PathVariable String id,@RequestBody @Valid Request request )
{
	requestService.addRequest(id,request);
	
	
}
@GetMapping
public List<Request> getAll()
{
	return requestService.getAll();
}
/*@GetMapping("/{id}")
public void getRequestDetails(@PathVariable String id)
{
	requestService.getRequestDetails(id);
}*/
}
