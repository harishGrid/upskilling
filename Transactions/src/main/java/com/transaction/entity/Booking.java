package com.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id @GeneratedValue
    private Long id;
    private Long roomId;
    private String guestName;
    private String status;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(Long id, Long roomId, String guestName, String status) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.guestName = guestName;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", roomId=" + roomId + ", guestName=" + guestName + ", status=" + status + "]";
	}
}