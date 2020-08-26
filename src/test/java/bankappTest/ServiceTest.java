package bankappTest;





import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bankapp.service.SignupService;



public class ServiceTest {
	
	@BeforeEach
	void beforeCheck() {
		System.out.println("before test");
	}
	
	@Test
	public void testCheck() {
		SignupService service = new SignupService();
		Assertions.assertEquals(5, service.toCheck("hello"));
	}
	
	@AfterEach
	void afterCheck() {
		System.out.println("after test");
	}

}
