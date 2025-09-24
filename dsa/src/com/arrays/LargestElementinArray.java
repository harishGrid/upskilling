package com.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;

public class LargestElementinArray {
	
	
	
	public static void main(String[] args) {
		 Integer arr[] =  {8,10,5,7,9};
		
		 Optional<Integer> max = Arrays.stream(arr).max(Integer::compareTo);
		 
		 System.out.println(max.get());
	}

}
