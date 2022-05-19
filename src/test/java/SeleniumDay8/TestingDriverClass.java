package SeleniumDay8;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import Utilities.Driver;

public class TestingDriverClass {
	
	
	@BeforeMethod
	public void setUp() {
		
		Driver.getDriver();
	
	}
	
	
	@Test
	public void test1() {
		System.out.println("Testing Browser opened");
	}
	
	
	@AfterMethod
	public void tearDown() {
		Driver.tearDown();
	}
	
	
	
	
	
	
	
	
	

}
