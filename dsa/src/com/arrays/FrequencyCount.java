package com.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCount {
	
	static Integer arr[] = {10,5,10,15,10,5};
	
	public static void main(String[] args) {
		
		 LinkedHashMap<Integer, Long> collect = Arrays.stream(arr)
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
		
		System.out.println(collect);
		
		countFreq(arr,arr.length);
	}
	
	public static void countFreq(Integer arr[], int n)
	{
	    boolean visited[] = new boolean[n];
	 
	    for (int i = 0; i < n; i++) {
	 
	        if (visited[i] == true)
	            continue;
	 
	        int count = 1;
	        for (int j = i + 1; j < n; j++) {
	            if (arr[i] == arr[j]) {
	                visited[j] = true;
	                count++;
	            }
	        }
	        System.out.println(arr[i] + " " + count);
	    }
	}

}
