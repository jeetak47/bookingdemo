package db;

import java.util.Set;

import model.Flight;

public abstract class DataFileReader {
	String fileName;

	public DataFileReader(String fileName) {
		super();
		this.fileName = fileName;
	}
	public abstract Set<Flight> searchResult(String oringin,String destination);
}
