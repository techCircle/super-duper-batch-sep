package SeleniumDay_10;

import org.testng.Assert;
import org.testng.annotations.Test;

public class groupDependencyTest {
	
	
	@Test(dependsOnGroups= {"SignIn"})
	public void ViewAccount() {
		System.out.println("Executes after 'SignIn' group of tests passes");
	}
	

	@Test(groups= {"SignIn"})
	public void OpenBrowser() {
		System.out.println("OpenBrowser");

	}
	

	@Test(groups= {"SignIn"})
	public void Login() {
		System.out.println("Login");

	}
	
	@Test(groups= {"SignIn"})
	public void Login2() {
		System.out.println("Login2");

	}
	
	@Test(groups= {"SignIn"})
	public void Login3() {
		System.out.println("Login3");
		Assert.assertTrue(false);

	}
	
	@Test(groups= {"SignIn"})
	public void Login4() {
		System.out.println("Login4");

	}
	
	
	
}
