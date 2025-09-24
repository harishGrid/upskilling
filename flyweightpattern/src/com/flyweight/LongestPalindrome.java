//package com.flyweight;
//
//import java.util.Arrays;
//
//public class LongestPalindrome {
//	
//	public static void main(String[] args) {
//		
//		String str = "My racecar is fast but not as fast as a madam";
//		
//		String[] split = str.split(" ");
//		
//		Arrays.stream(split).sorted()
//		System.out.println(string);
//		
//	}
//	
//	public static String isPalindrome(String word) {
//		String revStr="";
//		for(int i=word.length();i>0;i--) {
//			revStr+=word.charAt(i);
//		}
//		
//		if(word.equals(revStr)) {
//			return revStr;
//		}
//		return null;
//	}
//
//}
