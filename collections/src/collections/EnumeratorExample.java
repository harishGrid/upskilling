package collections;

import java.util.Enumeration;
import java.util.Vector;

public class EnumeratorExample {
	
	public static void main(String[] args) {
		
		Vector<String> v = new Vector<>();
		v.add("A");
		v.add("B");

		Enumeration<String> e = v.elements();
		
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
	}
	
}
