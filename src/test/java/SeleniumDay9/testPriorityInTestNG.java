package SeleniumDay9;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testPriorityInTestNG {

	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@Test(priority=1)
	public void C() {
		System.out.println("C");
	}

	@Test(priority=1)
	public void B() {
		System.out.println("B");
	}
	
	@Test(priority=2)
	public void A() {
		System.out.println("A");
	}

}
