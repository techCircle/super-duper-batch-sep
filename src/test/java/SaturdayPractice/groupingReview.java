package SaturdayPractice;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Utilities.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class groupingReview {

	@Test(priority =4 ,groups="batch10")
	public void Test() {
		System.out.println("priority 1 and batch10");
	}
	
	@Test(priority =3 ,groups= {"batch10", "login"})
	public void Test2() {
		System.out.println("priority 2 and login");

	}
	
	@Test(groups= {"batch10", "login", "smokeTest"}, priority =2)
	public void Test3() {
		System.out.println("grouped with the following batch10 - " + " - login - " + "smokeTest" + "== and priority 3");

	}
	
	@Test(priority =1 ,groups= {"batch10", "login", "lostBracelet"})
	public void Test4() {
		System.out.println("Found the bracelet" + "batch10"+ "login"+ "lostBracelet = priority 4");

	}

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() {
		BaseClass.getDriver();
	}

	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		//BaseClass.tearDown();
	}

}
