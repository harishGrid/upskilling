package com.collections;

import java.util.TreeSet;

public class Program2 {
	public static void main(String[] args) {
		TreeSet<Integer> numbers = new TreeSet<>((a, b) -> b - a);
		numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);

        System.out.println(numbers);
        
	}
}
