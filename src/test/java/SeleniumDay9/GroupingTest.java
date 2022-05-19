package SeleniumDay9;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.Driver;

public class GroupingTest {
	
	
	@Test(groups= {"smokeTest","Regression"})
	public void a() {
		System.out.println("a");
	}
	
	@Test(groups= "smokeTest")
	public void b() {
		System.out.println("b");
	}
	
	@Test(groups= {"Regression"})
	public void c() {
		System.out.println("c");
	}
	
	@Test(groups= {"Regression"})
	public void d() {
		System.out.println("d");
	}
	
	@Test(groups= {"Regression"})
	public void e() {
		System.out.println("e");
	}
	
	@Test(groups= {"NotThis"})
	public void f() {
		System.out.println("f");
	}

	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver();
	}

//	@AfterMethod
//	public void afterMethod() {
//		Driver.tearDown();
//	}

}
