package com.cognizant.onlinebloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.onlinebloodbank.model.Request;
import com.cognizant.onlinebloodbank.model.User;
import com.cognizant.onlinebloodbank.repository.RequestRepository;
import com.cognizant.onlinebloodbank.repository.UserRepository;
@Service
public class RequestService {
@Autowired
RequestRepository requestRepository;
@Autowired 
UserRepository userRepository;
public void addRequest(int id,Request request)
{
	User u=userRepository.findById(id).get();
	u.getRequests().add(request);
	request.setUserid(u);
	userRepository.save(u);
	requestRepository.save(request);
}
public List<Request> getAll()
{
	return requestRepository.getAll();
}
public void getRequestDetails(int id)
{
	User u=userRepository.findById(id).get();
	
}
}
