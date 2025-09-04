package com.collections;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetComparator {
	
	public static void main(String[] args) {
		
		Comparator<String> length=((s1,s2)->{
			int result = Integer.compare(s1.length(), s2.length());
			if(result==0) {
				return s1.compareTo(s2);
			}
			return result;
		});
		
		 TreeSet<String> set = new TreeSet<>(length.reversed());
	        set.add("Apple");
	        set.add("Mango");
	        set.add("Banana");
	        set.add("Kiwi");

	        System.out.println(set);
	}

}
