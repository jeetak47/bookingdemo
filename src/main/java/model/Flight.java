package model;

import java.text.ParseException;

import util.Utils;

public class Flight implements Comparable<Flight> {
	private String origin;
	private String destination;
	private long departureTime;
	private long destinationTime;
	private double price;
	
	
	public Flight() {
		super();
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public long getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(long departureTime) {
		this.departureTime = departureTime;
	}
	public long getDestinationTime() {
		return destinationTime;
	}
	public void setDestinationTime(long destinationTime) {
		this.destinationTime = destinationTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (departureTime ^ (departureTime >>> 32));
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + (int) (destinationTime ^ (destinationTime >>> 32));
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (departureTime != other.departureTime)
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (destinationTime != other.destinationTime)
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	public Flight(String origin, String destination, long departureTime, long destinationTime, double price) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.destinationTime = destinationTime;
		this.price = price;
	}
	@Override
	public String toString() {
		String formatdepartureTime=String.valueOf(departureTime);
		String formatdestinationTime=String.valueOf(destinationTime);
		String formatPrice=String.valueOf(price);
		try {
			  formatdepartureTime = Utils.formatDate(departureTime);
			  formatdestinationTime = Utils.formatDate(destinationTime);
			  formatPrice = Utils.formatPrice(price);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return  origin + " --> " + destination + " (" + formatdepartureTime
					+ " --> " + formatdestinationTime + ") - " + formatPrice ;
		
	}
	@Override
	public int compareTo(Flight o) {
		int result =0; 
		if(o!=null){
		result=	Double.compare(this.price,o.price);
			 if(result==0){
				 result =Long.compare(this.departureTime,o.departureTime);
			 }
		 }
		return result;
	}
	
}
