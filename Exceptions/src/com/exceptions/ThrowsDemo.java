package com.exceptions;

import java.io.FileReader;
import java.io.IOException;

public class ThrowsDemo {

	public static void main(String[] args) {
		
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("Exception Occured : "+e.getMessage());
		}
	}
	
	public static void readFile() throws IOException {
		FileReader file=new FileReader("harish.txt");
		file.read();
		file.close();
	}
	
}
