package com.exceptions;

class InvalidAgeException extends Exception{
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class CustomExceptionDemo {

	public static void main(String[] args) {
		try {
			calculateAge(15);
		} catch (InvalidAgeException e) {
			System.out.println("Exception Occured : "+e.getMessage());
		}
	}
	
	public static void calculateAge(int age) throws InvalidAgeException {
		if(age<18) {
			throw new InvalidAgeException("Not Eligible for vote");
		}else {
			System.out.println("Eligible for Vote");
		}
	}
}
