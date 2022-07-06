package SaturdayPractice;

import org.testng.annotations.Test;

import Utilities.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class priorityTestNG {
	
	
	@Test(priority=7)
	public void test() {
		System.out.println("test1");
	}
	
	@Test(priority=3)
	public void test2() {
		System.out.println("test2");
	}
	
	
	
	@Test(priority=2)
	public void test3() {
		System.out.println("test3");
	}
	
	
	
	@Test(priority=1)
	public void test4() {
		System.out.println("test4");
	}
	
	
	
	

	@BeforeMethod
	public void beforeMethod() {
		BaseClass.getDriver();

	}

	
	
	@AfterMethod
	public void afterMethod() {
		//BaseClass.tearDown();
	}

}
