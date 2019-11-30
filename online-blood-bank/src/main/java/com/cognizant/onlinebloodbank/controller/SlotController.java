package com.cognizant.onlinebloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.onlinebloodbank.exception.SlotsbookedException;
import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.Slot;
import com.cognizant.onlinebloodbank.model.User;
import com.cognizant.onlinebloodbank.repository.DonateRepository;
import com.cognizant.onlinebloodbank.repository.SlotRepository;
import com.cognizant.onlinebloodbank.repository.UserRepository;

@RestController
@RequestMapping("/slot")
public class SlotController {

	@Autowired
	SlotRepository slotRepository;
@Autowired 
DonateRepository donateRepository;
@Autowired
UserRepository userRepository;
@GetMapping
public List<Slot> getAll()
{
	return slotRepository.findAll();
}
	@PostMapping("/{id}")
	public void slotbooking(@PathVariable String id,@RequestBody Slot slot) throws SlotsbookedException
	{
		List<Slot> slots=slotRepository.findAll();
		Donate d=userRepository.findByUsername(id).getDonate();
		for(Slot s:slots)
		{
			if(d.getSlotid()==null){
			//System.out.println(slot.getDate().compareTo(s.getDate()));
			if(slot.getDate().compareTo(s.getDate())==1 && slot.getCity().equalsIgnoreCase(s.getCity())
					&& slot.getHospital().equalsIgnoreCase(s.getHospital())
					&& slot.getTime().equalsIgnoreCase(s.getTime()))
					{
				    throw new SlotsbookedException();
					}
			}
			
		}
		
		
	    slot.setSo_id(d.getDo_id());
		d.setSlotid(slot);
	
	   donateRepository.save(d);
	   // slotRepository.save(slot);
	}
	
}
