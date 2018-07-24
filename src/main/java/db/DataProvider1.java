package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;

import model.Flight;
import util.Utils;

public class DataProvider1 extends DataFileReader {

	public DataProvider1(String fileName) {
		super(fileName);
	}

	@Override
	public	Set<Flight> searchResult(String oringin, String destination) {
		Set<Flight> result=new HashSet<>();
		try {
			java.io.File file = new ClassPathResource(fileName).getFile();
			BufferedReader br = new BufferedReader(new FileReader(file));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] splitData = line.split(",");
				if(splitData.length>4){
					if(splitData[0].trim().equals(oringin.trim()) && splitData[2].trim().equals(destination.trim())){
						long departTime = Utils.parase1(splitData[1].trim());					
						long destTime = Utils.parase1(splitData[3].trim());
						double price = Utils.currencyParse(splitData[4].trim());
						Flight flight = new Flight(splitData[0].trim(), splitData[2].trim(), departTime, destTime, price);
						result.add(flight);
					}
					}
				}
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

}
