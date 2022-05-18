package SeleniumDay8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utilities.Driver;

public class TestingDriverClass {
	
	
	@Before
	public void setUp() {
		
		Driver.getDriver();
	
	}
	
	
	@Test
	public void test1() {
		System.out.println("Testing Browser opened");
	}
	
	
	@After
	public void tearDown() {
		Driver.tearDown();
	}
	
	
	
	
	
	
	
	
	

}
