package com.exceptions;

public class NumberFormatExceptionDemo {
	public static void main(String[] args) {
	
		String[] inputs = {"123", "abc", "456"};
		
		for(String input:inputs) {
			try {
			int number = Integer.parseInt(input);
			System.out.println(number);
			}catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
