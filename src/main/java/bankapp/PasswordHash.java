package bankapp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {
	
	public String passwordhash(String password) throws NoSuchAlgorithmException {
		
		MessageDigest md =MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte  [] bytes = md.digest();
		BigInteger number = new BigInteger(1,bytes);
		//converting to hex value
		String hashedText =  number.toString(16);
		//making to 32 bit and adding zeros if necessary
		while(hashedText.length()<32) {
			hashedText = "0"+ hashedText;
		}
		return hashedText;		
	}

}
