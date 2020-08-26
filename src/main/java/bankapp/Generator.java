package bankapp;

import java.util.Random;

public class Generator {
	
	public int accountNumberGenerator() {
		//account number should have 10 digits , should start with 112
		
		
		int begin = 1120000000;
		Random random = new Random();
		int acc_number  = begin + random.nextInt(9999999);
		
		
		return acc_number;
		
		
	}
	
	
	

}
