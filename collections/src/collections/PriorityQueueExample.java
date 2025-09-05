package collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
public static void main(String[] args) {
	PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    pq.add(30);
    pq.add(10);
    pq.add(20);

    while (!pq.isEmpty()) {
        System.out.println(pq.poll()); 
    }

}
}
