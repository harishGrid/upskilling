package com.exceptions;

public class ThrowDemo {
	public static void main(String[] args) {
		try {
		checkAge(15);
		}catch (ArithmeticException e) {
			System.out.println("Caught Exception : "+e.getMessage());
		}
		
	}
	
	public static void checkAge(int age) {
		if(age<18) {
			throw new ArithmeticException("Not Eligible to vote");
		}else {
			System.out.println("Eligible to vote");
		}
	}
}
