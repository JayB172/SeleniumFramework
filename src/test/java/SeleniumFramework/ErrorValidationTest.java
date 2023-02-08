package SeleniumFramework;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import SeleniumFramework.TestComponents.BaseTest;
 


public class ErrorValidationTest extends BaseTest {
	
	@Test

	public void submitOrder() throws IOException {
		// TODO Auto-generated method stub

		landingPageObject.performlogin("123abc@gmail.com" , "Abc@12345678910");
		String a = landingPageObject.getErrorMessage();
		System.out.println(a);
	}

}

	