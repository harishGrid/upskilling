package com.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id @GeneratedValue
    private Long id;
    private String roomNumber;
    private boolean available = true;
    private double pricePerNight;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(Long id, String roomNumber, boolean available, double pricePerNight) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.available = available;
		this.pricePerNight = pricePerNight;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", available=" + available + ", pricePerNight="
				+ pricePerNight + "]";
	}   
}