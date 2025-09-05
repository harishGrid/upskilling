package com.functional;

import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		
		Consumer<Integer> c=str->System.out.println(str);
		
		c.accept(10);
		
	}
}
