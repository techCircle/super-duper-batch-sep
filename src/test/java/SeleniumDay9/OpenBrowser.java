package SeleniumDay9;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Utilities.Driver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class OpenBrowser {
	
	
	@Test
	public void Test() {
	String titleName =	Driver.getDriver().getTitle();
		
	System.out.println(titleName);
	}

	
	
	
	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver();
	}

	@AfterMethod
	public void afterMethod() {
		Driver.tearDown();
	}

}
