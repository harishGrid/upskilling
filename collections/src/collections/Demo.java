package collections;
import java.util.*;

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " : " + salary;
    }
}

public class Demo {
    public static void main(String[] args) {
    	PriorityQueue<Employee> pq =new PriorityQueue<>(Comparator.comparingInt(s->s.salary));
        pq.add(new Employee("Alice", 50000));
        pq.add(new Employee("Bob", 70000));
        pq.add(new Employee("Charlie", 60000));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
