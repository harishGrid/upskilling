package com.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class FirstLongestPalindrome {
	
	public static void main(String[] args) {
		
		String input = "My racecar is fast but not as fast as a madam";
		
		String[] words = input.split(" ");
		
		Optional<String> max = Arrays.stream(words).filter(FirstLongestPalindrome::isPalindrome)
				.sorted(Comparator.reverseOrder()).skip(1).findFirst();
		                    //.max(Comparator.comparing(String::length));
		
		System.out.println(max.get());
		
		Optional<String> max2 = Arrays.stream(input.split(" ")).filter(word-> 
		word.equalsIgnoreCase(new StringBuffer(word).reverse().toString()))
		.max(Comparator.comparing(String::length));
		
		System.out.println(max2.get());
		
		String str = "programming";
		
		long count = str.chars().mapToObj(c->(char)c).filter(ch->"aeiou".indexOf(ch)>=0).count();
		
		System.out.println(count);
		
		
	}
	
	public static boolean isPalindrome(String str) {
		int left=0,right=str.length()-1;
		
		while(left<right) {
			if(Character.toLowerCase(str.charAt(left++))!=Character.toLowerCase(str.charAt(right--))) {
				return false;
			}
		}
		return true;
	}

}
