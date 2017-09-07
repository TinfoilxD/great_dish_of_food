package com.revature.gspj.gdf.regex;

public class InputValidatorHelper {
	
	private static String normalStringReg = "^[a-zA-Z0-9_.@-]*$";
	
	
	public static void checkString(String input){
		if(!input.matches(normalStringReg)){
			throw new IllegalArgumentException("Suspicious input");
		}
		
	}
}
