package com.payment.dto;


public class OrderEvent {
    private Long orderId;
    private Long customerId;
    private double amount;
    private String productId;
    private String status;
	public OrderEvent() {
		super();
	}
	public OrderEvent(Long orderId, Long customerId, double amount, String productId, String status) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.amount = amount;
		this.productId = productId;
		this.status = status;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderEvent [orderId=" + orderId + ", customerId=" + customerId + ", amount=" + amount + ", productId="
				+ productId + ", status=" + status + "]";
	}
   
}