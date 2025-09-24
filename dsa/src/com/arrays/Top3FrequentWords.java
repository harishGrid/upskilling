package com.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Top3FrequentWords {
	
	public static void main(String[] args) {
		
		List<String> sentences = Arrays.asList(
			    "Java is fun and powerful",
			    "Streams are powerful in Java",
			    "Java streams are cool and powerful"
			);
		
		Map<String, Long> collect = sentences.stream().map(s->s.split(" ")).flatMap(Arrays::stream)
		          .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		      LinkedHashMap<String, Long> collect2 = collect.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
		       .limit(3).collect(Collectors.toMap(Map.Entry::getKey,
		    		   Map.Entry::getValue,(a,b)->a,LinkedHashMap::new));
		      
		      System.out.println(collect2);

	}

}
