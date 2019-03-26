package com.patten.adapter2;

public class PrintBanner extends PrintTest{
	private Banner banner;
	
	public PrintBanner(String string) {
		this.banner = new Banner(string);
	}
	
	@Override
	public void printWeek() {
		banner.showWithParen();
		
	}

	@Override
	public void printStrong() {
		banner.showWithAster();
		
	}

	
	
}
