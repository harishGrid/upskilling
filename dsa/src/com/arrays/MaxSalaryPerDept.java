//package com.arrays;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//public class MaxSalaryPerDept {
//	public static void main(String[] args) {
//		List<Employee> employees = Arrays.asList(
//			    new Employee("Alice", "IT", 90000),
//			    new Employee("Bob", "IT", 120000),
//			    new Employee("Charlie", "HR", 70000),
//			    new Employee("David", "HR", 75000),
//			    new Employee("Eve", "Finance", 95000)
//			);
//		
//		employees.stream().collect(Collectors.groupingBy(Employee::))
//	}
//	record Employee(String name, String dept, int salary) {}
//	
//	
//	
//}
