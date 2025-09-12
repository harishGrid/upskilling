package com.adapter;
public class AdapterPatternDemo {
    public static void main(String[] args) {
    	
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        PaymentService service1 = new PaymentService(paypal);
        service1.process(100.0);

        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentService service2 = new PaymentService(stripe);
        service2.process(200.0);
    }
}
