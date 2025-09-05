package com.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateExample {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		LocalDate of = LocalDate.of(1998, 10, 13);
		System.out.println(of);
		
		LocalDate localDate = LocalDate.parse("1998-10-13");
		System.out.println(localDate);
		
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		
		Month month = localDate.getMonth();
		System.out.println(month);
		
		int dayOfMonth = localDate.getDayOfMonth();
		System.out.println(dayOfMonth);
	}
	
}
