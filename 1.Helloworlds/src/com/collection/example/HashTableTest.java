package com.collection.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class HashTableTest {

	public static void main(String[] args) {
		// Hashtable은 데이터 동기화 시 사용 
		
		// 데이터를 배열로 받음
		String[] data = {"data1", "data2", "data3", "data4", "data5"};
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		ht.clear();
		for(int idx=0; idx < data.length; idx++) {
			ht.put(idx, data[idx]); 
		}
//		Set<Integer> keys = ht.keySet();
		// key를 정렬하여 나열
		List<Integer> keyList = new ArrayList<Integer>(ht.keySet());
	    Collections.sort(keyList);
	    
	    // 대상 데이터 출력
		Iterator<Integer> it = keyList.iterator();
		int str = 0;
		while(it.hasNext()) {
			str = it.next();
			if(str == 1) {
				System.out.println("key 1 Value : " + ht.get(str));
			}
			System.out.println("key=" + str + " | value=" + ht.get(str));
		}
	}
	
}
