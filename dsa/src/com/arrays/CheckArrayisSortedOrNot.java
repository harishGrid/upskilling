package com.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CheckArrayisSortedOrNot {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5};
		int[] arr2 = {5, 4, 3, 2, 1};
		Integer[] arr3 = {1, 2, 3, 4, 5};


		
		boolean allMatch = IntStream.range(0, arr.length-1).allMatch(i->arr[i]<=arr[i+1]);
		
		System.out.println(allMatch);
		
		boolean allMatch2 = IntStream.range(0,arr2.length-1).allMatch(i -> arr2[i]>=arr2[i+1]);
		
		System.out.println(allMatch2);
		
		boolean isSortedAsc = IntStream.range(0, arr3.length - 1)
		        .allMatch(i -> arr3[i].compareTo(arr3[i + 1])>=0);
		
		System.out.println(isSortedAsc);
		
		boolean reduce = Arrays.stream(arr).boxed().reduce((prev,curr)->{
			if(prev > curr) {
				throw new IllegalStateException("Not Started");
			}
			return curr;
		}).isPresent();
		
		System.out.println(reduce);
	}

}
