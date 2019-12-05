package com.cognizant.onlinebloodbank.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.onlinebloodbank.exception.NoSearchResultException;
import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.Search;
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
		//donateRepository.save(donate);
	}
	@GetMapping
	public List<Donate> getAll()
	{
		return donateRepository.getAll();
		}
	
	@PostMapping
	public List<Donate> searchForDonor(@RequestBody Search search) throws NoSearchResultException
	{
		  List<Donate> dl= new ArrayList<Donate>();
		  dl=donateRepository.findAll();
		  List<Donate> newdl=new ArrayList<Donate>();
		  List<Donate> edl=new ArrayList<Donate>();
		  /*for(Donate d:dl)
		  {
			  Date date=new Date();
			  long duration=date.getTime()-d.getSlotid().getDate().getTime();
			    long days=TimeUnit.MILLISECONDS.toDays(duration);
			    if(days>95){
	                   edl.add(d);
			    }
			  
			  
		  }*/
		
		 
		  for(int j=0;j<dl.size();j++){
		         if(dl.get(j).getBloodgroup().equalsIgnoreCase(search.getBloodgroup())&&
		                       dl.get(j).getState().equalsIgnoreCase(search.getState())&&
		                       dl.get(j).getArea().equalsIgnoreCase(search.getArea())&&
		                       dl.get(j).getPincode()==search.getPincode()){
		        	 System.out.println(dl);
		                  newdl.add(dl.get(j));
		             }
		         }
		  System.out.println(newdl);
		  if(newdl.isEmpty())
			  throw new NoSearchResultException();
		         return newdl;
		  
	}
	/*@PostMapping
    public List<Donate> donorsearch(@RequestBody Search search){
         List<Donate> dl= new ArrayList<Donate>();
         List<Donate> newdl= new ArrayList<Donate>();
         donateRepository.findAll().forEach(dl::add);
         List<Donate> edl= new ArrayList<Donate>();
         for(int i=0;i<dl.size();i++){
        	 System.out.println(dl.get(i));
             Date curdate=new Date(0);
             long duration= curdate.getTime() - dl.get(i).getSlotid().getDate().getTime();
             long days=TimeUnit.MILLISECONDS.toDays(duration);
             if(days>95){
                  edl.add(dl.get(i));
             }}
         for(int j=0;j<dl.size();j++){
         if(dl.get(j).getBloodgroup().equalsIgnoreCase(search.getBloodgroup())&&
                       dl.get(j).getState().equalsIgnoreCase(search.getState())&&
                       dl.get(j).getArea().equalsIgnoreCase(search.getArea())&&
                       dl.get(j).getPincode()==search.getPincode()){
                  newdl.add(dl.get(j));
             }
         }
         
         
         return newdl;
    }
*/
	
}
