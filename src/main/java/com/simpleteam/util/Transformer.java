package com.simpleteam.util;

public class Transformer {

	public static Size toSize(String string){
		
		int index = string.indexOf("x");
		
		int x = Integer.valueOf(string.substring(0, index));	
		int y = Integer.valueOf(string.substring(++index, string.length()));
		
		return new Size(x,y);
	}
	
	
}
