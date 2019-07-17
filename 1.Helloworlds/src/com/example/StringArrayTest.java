package com.array.example;

import java.util.Arrays;

public class StringArrayTest {

	public static void main(String[] args) {
		String[] data = {"13", "6", "8", "11", "1"};
		data = stringArraySort(data);
		
		for(int i = 0; i < data.length; i++) {
			System.out.println("data : " + data[i]);
		}
	}
	
	public static String[] stringArraySort(String[] data) {
        int[] intData = new int[data.length];
        for(int i = 0; i < data.length; i++) {
            intData[i] = Integer.parseInt(data[i]);
        }
        
        for(int j = 0; j < intData.length; j++) {
            data[j] = String.valueOf(intData[j]);
        }
        
        return data;
    }
}
