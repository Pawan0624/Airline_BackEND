package com.wipro.velocity.model;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String source;
	
	private String destination;
	
	private String departure;
	
	private String arrival;
	
	//private Boolean oneWay;
	
	//private Boolean rent;
	
	private Date date;
	
	private int duration;
	
	private int passengers;

	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private float economy;
	private float buiseness;

	public Flight() {
		super();
	}

	public Flight(String id, String source, String destination, String departure, String arrival, Date date, int duration, int passengers, int capacity, float economy, float buiseness) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.date = date;
		this.duration = duration;
		this.passengers = passengers;
		this.capacity = capacity;
		this.economy = economy;
		this.buiseness = buiseness;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public float getEconomy() {
		return economy;
	}

	public void setEconomy(float economy) {
		this.economy = economy;
	}

	public float getBuiseness() {
		return buiseness;
	}

	public void setBuiseness(float buiseness) {
		this.buiseness = buiseness;
	}

}
