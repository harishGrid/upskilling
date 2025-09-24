package com.arrays;

import java.util.*;
import java.util.stream.Collectors;
class Employee1{
	public String name;
	public String dept;
	public Integer salary;
	public Employee1(String name, String dept, Integer salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee1 [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	
}
public class FlatMapExample {
	
	public static void main(String[] args) {
		
		List<Employee1> employees = Arrays.asList(
			       new Employee1("Alice", "HR", 70000),
			       new Employee1("Bob", "IT", 90000),
			       new Employee1("Charlie", "HR", 85000),
			       new Employee1("David", "IT", 120000),
			       new Employee1("Eve", "Finance", 95000)
			);
		
		Map<String, Optional<Employee1>> collect = employees.stream()
				.collect(Collectors.groupingBy(Employee1::getDept,
						Collectors.maxBy(Comparator.comparing(Employee1::getSalary))));
		
		System.out.println(collect);
		
		List<String> sentences = Arrays.asList(
			       "Java is fun",
			       "Streams are powerful",
			       "Java streams are cool"
			);
		
		List<String> collect2 = sentences.stream().map(s->s.split(" ")).flatMap(Arrays::stream).map(s->s.toLowerCase()).distinct().collect(Collectors.toList());
	
		System.out.println(collect2);
	}

}
