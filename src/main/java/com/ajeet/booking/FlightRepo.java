package com.ajeet.booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import db.DataFileReader;
import db.DataProvider1;
import db.DataProvider2;
import db.DataProvider3;
import model.Flight;

@Component
public class FlightRepo {
	private List<DataFileReader> dataSource = new ArrayList<>();

	public FlightRepo() {
		super();
		dataSource.add(new DataProvider1("provider1.txt"));
		dataSource.add(new DataProvider2("provider2.txt"));
		dataSource.add(new DataProvider3("provider3.txt"));
		
	}
	
public	List<Flight> searchFlights(String origin,String destination){
		Set<Flight> flights =new HashSet<>();
		for (DataFileReader ds : dataSource) {
			flights.addAll(ds.searchResult(origin, destination));
		}
		List<Flight> list = new ArrayList<>();
		list.addAll(flights);
		Collections.sort(list);
		return list;
	}
}
