package com.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class SecondLargestElement {
	
	public static void main(String[] args) {
		 
		Integer arr[] =  {8,10,5,7,9};
		
		Optional<Integer> max = Arrays.stream(arr).max(Comparator.naturalOrder());
		System.out.println(max);
		 
	}

}
