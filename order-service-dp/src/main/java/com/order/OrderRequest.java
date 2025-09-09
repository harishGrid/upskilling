package com.order;

public class OrderRequest {
    private Long customerId;
    private double amount;
    private String productId;
	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderRequest(Long customerId, double amount, String productId) {
		super();
		this.customerId = customerId;
		this.amount = amount;
		this.productId = productId;
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
	@Override
	public String toString() {
		return "OrderRequest [customerId=" + customerId + ", amount=" + amount + ", productId=" + productId + "]";
	}
    
    
}