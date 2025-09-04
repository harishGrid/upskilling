package com.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Payment {
    @Id @GeneratedValue
    private Long id;
    private Long bookingId;
    private double amount;
    private String status;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(Long id, Long bookingId, double amount, String status) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.amount = amount;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", bookingId=" + bookingId + ", amount=" + amount + ", status=" + status + "]";
	}
}