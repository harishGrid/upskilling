package com.functional;

import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		Predicate<Integer> p= n -> n % 2 == 0;

		 System.out.println(p.test(10)); // true
	       System.out.println(p.test(7));  // false
	}
}
