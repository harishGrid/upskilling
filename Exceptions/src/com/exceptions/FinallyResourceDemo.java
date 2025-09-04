package com.exceptions;
import java.io.*;

public class FinallyResourceDemo {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
            System.out.println("First line: " + reader.readLine());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                System.out.println("Reader closed");
            } catch (IOException e) {
                System.out.println("Error closing reader");
            }
        }
    }
}