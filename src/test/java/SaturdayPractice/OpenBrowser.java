package SaturdayPractice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.BaseClass;

public class OpenBrowser {

	@Test
	public void TestingBaseClass() {
		//pulling data from config properties
		
		System.out.println(BaseClass.getProperty("name"));
		System.out.println(BaseClass.getProperty("email"));
		System.out.println(BaseClass.getProperty("text"));
		
		
		//pulling data from userData properties
		String userName = "userName = "+ BaseClass.getUserDataProperty("username");
		String passWord = "passWord = "+BaseClass.getUserDataProperty("password");
		String phone = "phone = "+BaseClass.getUserDataProperty("phone");
		String gender = "gender = "+BaseClass.getUserDataProperty("gender");

		System.out.println(userName);
		System.out.println(passWord);
		System.out.println(phone);
		System.out.println(gender);

		
//		name=shafkat
//		email=abc@gmail.com
//
//		text=Testing Browser opened

	}

	@BeforeMethod
	public void beforeMethod() {

		BaseClass.getDriver();

	}

	@AfterMethod
	public void afterMethod() {
		BaseClass.tearDown();
	}

}
