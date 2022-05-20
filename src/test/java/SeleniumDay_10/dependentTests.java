package SeleniumDay_10;

import org.testng.annotations.Test;

import Utilities.Driver;


import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class dependentTests {
	
	
	
	
	@Test(dependsOnMethods = {"OpenBrowser", "OpenBrowser2"})
	public void AclickOnRSVP() {
		
		System.out.println("this will execute second(clickOnRSVP), it depends on 'OpenBrowser' Method");
	}
	

	@Test
	public void OpenBrowser() {
		
		System.out.println("this will execute first(OpenBrowser)");
		
		Assert.assertTrue(true);
	}
	
	
	@Test
	public void OpenBrowser2() {
		
		System.out.println("this will execute first(OpenBrowser)");
		
		Assert.assertTrue(true);
	}
	
	
	
	@Test(dependsOnMethods = {"AclickOnRSVP"})
	public void thirdMethod() {
		
		System.out.println("this depends on 'AclickOnRSVP' method");
		
	}
	
	

	

}
