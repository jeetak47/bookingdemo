package com.ajeet.booking;

import java.util.List;

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
		if(origin==null || origin.isEmpty() || destination==null || destination.isEmpty()){
			data.append("Origin and Destination required");
			return new ResponseEntity<String>(data.toString(), HttpStatus.OK);
		}
		List<Flight> searchFlights = repo.searchFlights(origin, destination);
		for (Flight flight : searchFlights) {
			data.append(flight.toString());
			data.append("\n");
		}
		if(searchFlights.isEmpty()){
			data.append("No Flights Found for ");
			data.append(origin);
			data.append(" --> ");
			data.append(destination);
		}
		return new ResponseEntity<String>(data.toString(), HttpStatus.OK);
	}
	
}
