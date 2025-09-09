package com.order.entity;

import com.order.OrderStatus;

import jakarta.persistence.*;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private double amount;
    private String productId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Long id, Long customerId, double amount, String productId, OrderStatus status) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.amount = amount;
		this.productId = productId;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", amount=" + amount + ", productId=" + productId
				+ ", status=" + status + "]";
	}
}