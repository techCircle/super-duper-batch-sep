package anoma51TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import apPageObjects.LoginPage;
import apUtilities.BaseClass;

public class LoginFunctionality {

	LoginPage lp = new LoginPage();

	@BeforeSuite
	public void setUp() throws InterruptedException {
		BaseClass.getDriver();
	}

	@BeforeMethod
	public void beforeTest() {
		lp.accountMenu.click();
	}

	@Test(groups="anoma",priority=1)
	public void loginWithValidCreditial() {
		lp.usernameInput.sendKeys(BaseClass.getProperty("validUsername"));
		lp.passwordInput.sendKeys(BaseClass.getProperty("validPassword"));
		lp.submitBtn.click();
		lp.verifyLogin();
		lp.signOutBtn.click();
	}

	@Test(groups="anoma",priority=2)
	public void loginWithInvalidUsernameAndInvalidPassword() {
		lp.usernameInput.sendKeys(BaseClass.getProperty("invalidUsername"));
		lp.passwordInput.sendKeys(BaseClass.getProperty("invalidPassword"));
		lp.submitBtn.click();
		lp.VerifyLoginError();
	}

	@Test(groups="anoma",priority=3)
	public void loginWithValidUsernameEmptyPassword() {
		lp.usernameInput.sendKeys(BaseClass.getProperty("validUsername"));
		lp.passwordInput.sendKeys("");
		lp.submitBtn.click();
		lp.VerifyLoginError();
	}

	@Test(groups ="anoma",priority=4)
	public void loginWithEmptyUsernameValidPassword() {
		lp.usernameInput.sendKeys("");
		lp.passwordInput.sendKeys(BaseClass.getProperty("validPassword"));
		lp.submitBtn.click();
		lp.VerifyLoginError();
	}

	@Test(groups="anoma",priority=5)
	public void loginWithEmptyUsernameEmptyPassword() {
		lp.usernameInput.sendKeys("");
		lp.passwordInput.sendKeys("");
		lp.submitBtn.click();
		lp.VerifyLoginError();
	}

	@Test(groups="anoma",priority=6)
	public void passwordMasked() {
		lp.passwordInput.sendKeys("");
		lp.submitBtn.click();
		lp.VerifyLoginMasked();
	}

	@Test(groups="anoma",priority=7)
	public void loginWithCaseSensitive() {
		lp.usernameInput.sendKeys(BaseClass.getProperty("casesUsername"));
		lp.passwordInput.sendKeys(BaseClass.getProperty("casesPassword"));
		lp.submitBtn.click();
		lp.VerifyLoginError();
	}

	@Test(groups="anoma",priority=8)
	public void loginAuthentication() {
		lp.usernameInput.sendKeys(BaseClass.getProperty("validUsername"));
		lp.passwordInput.sendKeys(BaseClass.getProperty("validPassword"));
		lp.submitBtn.click();
		lp.signOutBtn.click();
		BaseClass.driver.navigate().back();
		lp.VerifySignout();
	}

	@AfterSuite
	public void tearDown() {
		BaseClass.tearDown();
	}

}
