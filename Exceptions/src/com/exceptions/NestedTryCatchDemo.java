package com.exceptions;
public class NestedTryCatchDemo {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            try {
                arr[10] = 50;  
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: " + e);
            }

            int result = 10 / 0;  
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: " + e);
        }
    }
}