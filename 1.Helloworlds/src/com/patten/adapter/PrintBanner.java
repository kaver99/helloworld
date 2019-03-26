package com.patten.adapter;

public class PrintBanner extends Banner implements PrintTest{

	public PrintBanner(String string) {
		super(string);
	}

	@Override
	public void printWeek() {
		showWithParen();
		
	}

	@Override
	public void printStrong() {
		showWithAster();
		
	}
	
}
