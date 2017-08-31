package com.revature.gspj.gdf.password;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordManager {
	
	public static String hashPassword(String plain_password){
		String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());
		return pw_hash;
	}
	
	public static boolean checkHashedPassword(String enteredPassword, String storedHash){
		boolean correct = BCrypt.checkpw(enteredPassword, storedHash);
		return correct;
		
	}
	


}
