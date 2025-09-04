package com.exceptions;

public class MultiCatchDemo {
	public static void main(String[] args) {
		try {
		int arr[]=new int[3];
		int num=arr[5];
		int result=num/0;
		System.out.println(result);
		}catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}
