package com.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee{
	public Integer id;
	public String section;
	public String dept;
	public String email;
	public String city;
	public Integer salary;
	public Employee(Integer id, String section, String dept, String email, String city, Integer salary) {
		super();
		this.id = id;
		this.section = section;
		this.dept = dept;
		this.email = email;
		this.city = city;
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", section=" + section + ", dept=" + dept + ", email=" + email + ", city=" + city
				+ ", salary=" + salary + "]";
	}
	
	
	
	
	
}
public class Test {
	
	public static void main(String[] args) {
		
		Map<Employee, Integer> mapSortReversed = new HashMap<>();

		mapSortReversed.put(new Employee(3,"A","IT","gmail","Chennai",100), 100);
		mapSortReversed.put(new Employee(4,"B","IT","gmail","Delhi",200),200);
		mapSortReversed.put(new Employee(1,"C","IT","gmail","Chennai",300),300);
		mapSortReversed.put(new Employee(2,"D","IT","gmail","Mumbai",400),400);
	
	
	                	        
		
		mapSortReversed.entrySet().stream()
		               .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getId)))
		               .forEach(s -> System.out.println(s.getKey()+ " "+s.getValue()));
	
		
		String str = "Streams are powerful";
		
		LinkedHashMap<Character, Long> collect = str.chars().mapToObj(c->(char)c).collect(Collectors.
				groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		
		
		Optional<Entry<Character, Long>> first = collect.entrySet().stream().filter(s->s.getValue()==1).skip(1).findFirst();
	
		System.out.println(first.get());
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
