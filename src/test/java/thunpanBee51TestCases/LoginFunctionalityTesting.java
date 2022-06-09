package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFunctionalityTesting extends PageInitialized {

	@BeforeClass
	public void setUp() {
		Driver.getDriver();
		System.out.println("Successful Open Browser");

	}

	@BeforeMethod
	public void beforeTest() {
		accPage.clickAccBtn();

	}

	@Test
	public void TC001_LoginWithValidUsernameAndPassword() {
		accPage.inputValidEmailAndPassword();
		accPage.loginVerify();
		accPage.clickOnSignOutBtn();
	}

	@Test
	public void TC002_LoginWithIncorrectUsernameAndIncorrectPassword() {
		accPage.inputInvalidLogin();
		accPage.varifyInvalidUsernameMessage();
	}

	@Test
	public void TC003_LoginWithCorrectUsernameAndEmptyPassword() {
		accPage.inputEmptyPasswordLogin();
		accPage.varifyEmptyPassword();
	}

	@Test
	public void TC004_LoginWithEmptyUsernameAndValidPassword() {
		accPage.inputEmptyUsernamelogin();
		accPage.verifyEmptyUsername();

	}

	@Test
	public void TC005_LoginWithEmptyUsernameAndEmptyPassword() {
		accPage.inputEmpty();
		accPage.verifyEmptyUsername();

	}

	@Test
	public void TC006_LoginPasswordShouldBeMasked() {
		accPage.inputCharacterPassword();
		accPage.verifyPasswordBeMasked();
		Driver.takeScreenshot("Displayed asterisks", accPage.loginForm);

	}

	@Test
	public void TC007_LoginHandlesCaseSensitive() {
		accPage.inputCaseSensitive();
		accPage.varifyInvalidUsernameMessage();

	}

	@Test
	public void TC008_LoginAuthentication() {
		accPage.inputValidEmailAndPassword();
		accPage.loginVerify();
		accPage.clickOnSignOutBtn();
		Driver.navBack();
		accPage.verifyLabel();
		Driver.getURL();
	}

	@AfterClass
	public void Destroy() {
		Driver.destroy();
	}
}
