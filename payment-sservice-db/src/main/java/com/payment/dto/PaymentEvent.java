package com.payment.dto;

public class PaymentEvent {
    private Long orderId;
    private String status;
	public PaymentEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentEvent(Long orderId, String status) {
		super();
		this.orderId = orderId;
		this.status = status;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PaymentEvent [orderId=" + orderId + ", status=" + status + "]";
	}
    
    
}