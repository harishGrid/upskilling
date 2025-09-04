package com.exceptions;

public class ArithmeticExceptionDemo {
	public static void main(String[] args) {
		
		try {
			int a=10,b=0;
			int result=a/b;
			System.out.println(result);
		}catch (ArithmeticException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Exception Completed");
		}
	}
}
