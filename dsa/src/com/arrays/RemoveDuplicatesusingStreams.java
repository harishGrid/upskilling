package com.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RemoveDuplicatesusingStreams {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 1, 2, 2, 3, 3, 4};
		
		int[] unsortArr = {4, 2, 1, 3, 2, 4, 5, 1};
        
		int[] array = Arrays.stream(arr).distinct().toArray();
		
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
		LinkedHashSet<Integer> collect = Arrays.stream(arr).boxed()
				.collect(Collectors.toCollection(LinkedHashSet::new));
		
		System.out.println(collect);
		
		int removeDuplicates = removeDuplicates(arr);
		System.out.println(removeDuplicates);
	}
	
	
	static int removeDuplicates(int arr[]) {
		int i=0;
		for(int j=1;j<arr.length;j++) {
			if(arr[i]!=arr[j]) {
				i++;
				arr[i]=arr[j];
			}
		}
		return i+1;
	}
	
}
