package com.collections;
import java.util.*;

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class TreeSetComparatorExample3 {
    public static void main(String[] args) {
    	
    	Comparator<Employee> salaryComparator=((e1,e2)->{
    		return Integer.compare(e1.salary, e2.salary);
    		
    	});
    	
    	Comparator<Employee> salaryComparatorThenName=((e1,e2)->{
    		int compare = Integer.compare(e1.salary, e2.salary);
    		if(compare==0) {
    			return e1.name.compareTo(e2.name);
    		}
    		return compare;
    	});
    	
        TreeSet<Employee> employees = new TreeSet<>(salaryComparator);

        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("AAob", 50000));
        employees.add(new Employee("Charlie", 60000));

        System.out.println(employees);
    }
}
