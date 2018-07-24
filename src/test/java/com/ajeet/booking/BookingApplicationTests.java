package com.ajeet.booking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import model.Flight;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingApplicationTests {

	@Test
	public void contextLoads() {
	}

	
	 	@Autowired
	    private FlightRepo repo;
	    @Test
	    public void countresult() {
	    	int size = repo.searchFlights("YYZ", "YYC").size();
	    	assertEquals(3, size);
	    }
	    @Test
	    public void sortresult() {
	    	Flight flight = repo.searchFlights("YYZ", "YYC").get(0);
	    	assertFalse(flight.getPrice()!=578d);
	    }
	    
	    
	    
}
