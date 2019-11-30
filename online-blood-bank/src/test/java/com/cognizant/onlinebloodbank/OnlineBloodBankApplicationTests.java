package com.cognizant.onlinebloodbank;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.onlinebloodbank.model.Donate;
import com.cognizant.onlinebloodbank.repository.DonateRepository;
import com.cognizant.onlinebloodbank.repository.UserRepository;

@SpringBootTest
class OnlineBloodBankApplicationTests {
@Autowired
	UserRepository userRepository;
@Autowired
DonateRepository donateRepository;
	
	@Test
	void contextLoads() {
	}
	@Test
	public void findname() {
	    // given
	    /*Employee alex = new Employee("alex");
	    entityManager.persist(alex);
	    entityManager.flush();
	 
	    // when
	    Employee found = employeeRepository.findByName(alex.getName());
	 
	    // then
	    assertThat(found.getName())
	      .isEqualTo(alex.getName());
	     */
	  
	   
	    
	}

}
