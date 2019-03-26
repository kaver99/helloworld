package com.patten.adapter;

public class AdapterMain {

	public static void main(String[] args) {
		PrintTest p = new PrintBanner("Hello");
		p.printWeek();
		p.printStrong();
	}
}
