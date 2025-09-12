package com.adapter;

public class StripeGateway {
	public void makePayment(double amountInDollars) {
		System.out.println("Paid " + amountInDollars + " via Stripe.");
	}
}
