package com.operator.example;

public class OperatorTest {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 10;
		int c = 10;
		int d = 10;
		int z = 2;
		
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		
		result1 = ++a + z;
		System.out.println("result1 : " + result1 + " | a : " + a);
		result2 = b++ + z;
		System.out.println("result2 : " + result2 + " | b : " + b);
		result3 = --c - z;
		System.out.println("result3 : " + result3 + " | c : " + c);
		result4 = d-- - z;
		System.out.println("result4 : " + result4 + " | d : " + d);
		
	}
}
