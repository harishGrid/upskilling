package collections;

import java.util.*;

public class IteratorExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("X");
		list.add("Y");
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
