package com.functional;

import java.util.function.Function;

public class FunctionExample {
	public static void main(String[] args) {
		Function<Integer, Integer> f=a->a*a;
		Integer apply = f.apply(2);
		System.out.println(apply);
	}
}
