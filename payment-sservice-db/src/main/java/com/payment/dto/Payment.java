package com.payment.dto;

public class Payment {
    private Long id;
    private Long orderId;
    private double amount;
    private String status;
	public Payment() {
		super();
	}
	public Payment(Long id, Long orderId, double amount, String status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.amount = amount;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
		return "Payment [id=" + id + ", orderId=" + orderId + ", amount=" + amount + ", status=" + status + "]";
	}
}