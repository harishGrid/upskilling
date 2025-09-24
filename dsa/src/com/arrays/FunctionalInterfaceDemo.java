package com.arrays;

@FunctionalInterface
interface Sample{
	void print();
}

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		
		Sample s=()-> {
			System.out.println("Hello");
		};
		
		s.print();
	}
	
}
