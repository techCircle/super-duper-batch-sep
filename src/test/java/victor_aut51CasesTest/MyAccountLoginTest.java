package victor_aut51CasesTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import victor.utilities.Victor_BaseClass;
import victor.automationTesting.pages.MyAccountPage;

public class MyAccountLoginTest {
	MyAccountPage mAP = new MyAccountPage ();
	
	@BeforeMethod
    public void setUp() {
		Victor_BaseClass.getDriver();
		mAP.myAccount.click();
	}
	
	@Test(priority= 1, enabled = false)
	public void LoginWithValidUsernameAndPassword () {
		mAP.loginWithValidUserAndPAssword();	
	}
	
	@Test(priority= 2, enabled = false)
	public void LoginWithIncorrectUsernameAndIncorrectPassword () {
		mAP.loginWithInvalidUserAndPAssword();
	}
	
	@Test(priority= 3, enabled = false)
	public void LoginWithCorrectUsernameAndEmptyPassword () {
		mAP.loginWithValidUserAndEmpyPAssword();
	}
	
	@Test(priority= 4, enabled = false)	
	public void LoginWithEmpyUsernameAndValidPassword () {
		mAP.loginWithEmpyUserAndValidPAssword();
	}
	
	@Test(priority= 5, enabled = false)
	public void LoginWithEmpyUsernameAndEmptyPassword () {
		mAP.loginWithEmpyUserAndEmptyPAssword();
	}
	
	@Test(priority= 6, enabled = false)
	public void LogInPasswordShouldBeMasked () {
		mAP.passwordField();
	}
	
	@Test(priority= 7, enabled = false)
	public void LoginHandlesCaseSensitive () {
	
		mAP.loginWithValidUserAndPsasword();
	}
	
	@Test(priority= 8, enabled = true)
	public void LoginAuthentication () {
	
		mAP.loginWithValidUserAndPAssword();
		mAP.logout.click();
		Victor_BaseClass.driver.navigate().back();
		Assert.assertTrue(mAP.loginButton.isDisplayed());
	}
	
	@AfterMethod
	 public void tearDown() {
	   Victor_BaseClass.tearDown();
	 }
}
