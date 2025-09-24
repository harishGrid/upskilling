package com.maths;

public class CountDigits {
	
	static int number =12345;

public static int count(int num) {
	int cnt=0;
	while(num>0) {
		cnt+=1;
		num=num/10;
	}
	return cnt;
	
	
}

	public static void main(String[] args) {
		int count = count(number);
		System.out.println(count);
	}
}

