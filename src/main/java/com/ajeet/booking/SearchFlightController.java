package com.ajeet.booking;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Flight;

@RestController
public class SearchFlightController {

	@Autowired
	FlightRepo repo;
	
	@RequestMapping(value = "/searchFlights/{origin}/{destination}", method = RequestMethod.GET)
	ResponseEntity<String> getFlights(@PathVariable("origin") String origin,@PathVariable("destination") String destination) {
		StringBuffer  data =new StringBuffer();
		Set<Flight> searchFlights = repo.searchFlights(origin, destination);
		 List<Object> asList = Arrays.asList(searchFlights.toArray());
		for (Object flight : asList) {
			data.append(flight.toString());
			data.append("\n");
		}
		return new ResponseEntity<String>(data.toString(), HttpStatus.OK);
	}
	
}
