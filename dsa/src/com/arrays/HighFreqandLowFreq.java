package com.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighFreqandLowFreq {

		
		static Integer arr[] = {10,5,10,15,10,5};
		
		public static void main(String[] args) {
			
			 LinkedHashMap<Integer, Long> collect = Arrays.stream(arr)
					.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
			
			 Optional<Entry<Integer, Long>> max = collect.entrySet().stream().max(Map.Entry.comparingByValue());
			 
			 Optional<Entry<Integer, Long>> min = collect.entrySet().stream().min(Map.Entry.comparingByValue());
			System.out.println(max.get());
			System.out.println(min.get());
			
			countFreq(arr,arr.length);
			
		}
		
		public static void countFreq(Integer arr[],int n) {
			boolean visited[] = new boolean[n];
			int maxFreq = 0, minFreq = n;
	        int maxEle = 0, minEle = 0;
			for(int i=0;i<arr.length;i++) {
				 if (visited[i] == true)
		                continue;
				int count=1;
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i]==arr[j]) {
						count++;
					}
				}
				if (count > maxFreq) {
	                maxEle = arr[i];
	                maxFreq = count;
	            }
	            if (count < minFreq) {
	                minEle = arr[i];
	                minFreq = count;
	            }
			}
			System.out.println("The highest frequency element is: " + maxEle);
	        System.out.println("The lowest frequency element is: " + minEle);
		}
		
	}

