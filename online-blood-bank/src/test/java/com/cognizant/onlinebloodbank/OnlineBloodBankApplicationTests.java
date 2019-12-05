package com.cognizant.onlinebloodbank;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.onlinebloodbank.controller.SlotController;
import com.cognizant.onlinebloodbank.controller.donateController;
import com.cognizant.onlinebloodbank.exception.AlreadySlotExistsException;
import com.cognizant.onlinebloodbank.exception.SlotsbookedException;
import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.model.Request;
import com.cognizant.onlinebloodbank.model.Slot;
import com.cognizant.onlinebloodbank.model.User;
import com.cognizant.onlinebloodbank.repository.UserRepository;
import com.cognizant.onlinebloodbank.service.RequestService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=OnlineBloodBankApplication.class)

public class OnlineBloodBankApplicationTests {
//@Autowired
//	UserRepository userRepository;
//@Autowired
//DonateRepository donateRepository;
	
@Autowired
private UserRepository urepository;
@Autowired
private RequestService service;
@Autowired
private donateController dcontroller;
@Autowired
private SlotController slotController;

@Test
public void testaddreq(){
Request br= new Request();
br.setArea("abcd");
br.setBloodgroup("B+ve");
br.setContactnumber("1234567890");
br.setState("Andhra Pradesh");
br.setPincode(123456);
User u=urepository.findByUsername("c");
service.addRequest(u.getUsername(), br);
boolean st = false;
for(int i=0;i<u.getRequests().size();i++){
                if(u.getRequests().get(i).getContactnumber().equalsIgnoreCase("1234567890"))
                                st=true;
}
assertEquals(st,true);
}

@Test
public void testdonor(){
                Donate dr= new Donate();
                dr.setArea("Andaman and Nicobar Islands");
                dr.setBloodgroup("O+ve");
                dr.setContactnumber("1234561234");
                dr.setState("Andaman and Nicobar Islands");
                dcontroller.addDonor("c", dr);
                User u=urepository.findByUsername("c");
                assertEquals(u.getDonate().getBloodgroup(),"O+ve");
}

@Test
public void testslot() throws ParseException{
     Slot hs=new Slot();
     hs.setCity("Bangalore");
     hs.setHospital("Apollo");
     hs.setTime("9am-10am");
     String str="2019-11-11";
     Date d=new SimpleDateFormat("yyyy-MM-dd").parse(str);
     hs.setDate(d);
//   User u=urepository.findByUsername("thor");
         
//   boolean st=false;
//   if(u.getDonor().getSlot()!=null)
//       st=true;
     try {
         slotController.slotbooking("c",hs);
        // fail();
     } catch (SlotsbookedException | AlreadySlotExistsException e) {
         // TODO Auto-generated catch block
         String expected="Slot already booked";
         System.out.println(e.getMessage());
         assertEquals(expected,e.getMessage());
     }
}


/*@Test
public void testexception(){
     Slot hs=new Slot();
     hs.setCity("Bangalore");
     hs.setHospitalname("Apollo");
     hs.setTimeslot("9 to 10");
     String str="2019-12-02";
     Date d= Date.valueOf(str);
     hs.setSlotdate(d);
//   User u=urepository.findByUsername("thor");
         
//   boolean st=false;
//   if(u.getDonor().getSlot()!=null)
//       st=true;
     try {
         slotservice.book("realuser",hs);
         fail();
     } catch (SlotsBookedException | AlreadySlotExistsException e) {
         // TODO Auto-generated catch block
         String expected="You have an active slot";
         assertEquals(expected,e.getMessage());
     }
}
*/
   
	    
	}

//}
