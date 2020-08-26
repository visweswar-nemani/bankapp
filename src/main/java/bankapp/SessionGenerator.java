package bankapp;

import org.apache.commons.lang3.RandomStringUtils;

public class SessionGenerator {
	
	public String generateSessionKey() {		
		
		return RandomStringUtils.randomAlphanumeric(16);
			
	}

}
