package com.cognizant.onlinebloodbank.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.onlinebloodbank.exception.AlreadySlotExistsException;
import com.cognizant.onlinebloodbank.exception.SlotsbookedException;
import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.Slot;
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
	public boolean slotbooking(@PathVariable String id,@RequestBody Slot slot) throws SlotsbookedException, AlreadySlotExistsException
	{
		List<Slot> slots=slotRepository.findAll();
		Donate d=userRepository.findByUsername(id).getDonate();
		for(Slot s:slots)
		{
			if(d.getSlotid()==null){
				Date d1=new Date();
				d1=slot.getDate();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date d2=new Date();
				d2=s.getDate();
				
				System.out.println(formatter.format(d1)+"     "+s.getDate());
			System.out.println(formatter.format(d1).compareTo(formatter.format(d2)));
			if(formatter.format(d1).compareTo(formatter.format(d2))==0 && slot.getCity().equalsIgnoreCase(s.getCity())
					&& slot.getHospital().equalsIgnoreCase(s.getHospital())
					&& slot.getTime().equalsIgnoreCase(s.getTime()))
					{
				    throw new SlotsbookedException();
					}
			}
			else
			{
				Date curdate=new Date();
				long duration =curdate.getTime() - d.getSlotid().getDate().getTime();
				long days=TimeUnit.MILLISECONDS.toDays(duration);
				if(days>95)
				{
					System.out.println(days);
					slot.setDonateid(d);
					d.setSlotid(slot);
					donateRepository.save(d);
					return false;
					
				}
				else
				{
					throw new AlreadySlotExistsException();
				}
			}
			
		}
		
		
		
	    slot.setSo_id(d.getDo_id());
		d.setSlotid(slot);
	
	   donateRepository.save(d);
	   // slotRepository.save(slot);
		return true;
	}
	
}
