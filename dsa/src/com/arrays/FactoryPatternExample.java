package com.arrays;

interface Notification{
	void sendMessage();
}

class SmsNotification implements Notification{

	@Override
	public void sendMessage() {
		System.out.println("Send Message through sms");
	}
	
}

class EmailNotification implements Notification{

	@Override
	public void sendMessage() {
		System.out.println("send message through email");
	}
	
}
public class FactoryPatternExample{
	
	public static Notification factorydemo(String type) {
		if(type.equals("sms")) {
			return new SmsNotification();
		}else if(type.equals("email")) {
			return new EmailNotification();
		}else {
			return null;
		}
	}	
	
	
}
