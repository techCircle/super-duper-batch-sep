package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import thunpanBee51TestCasesPageObj.AccountPageObj;

public class LoginFunctionalityTesting {
	private AccountPageObj loginPage;

	@BeforeClass
	public void setUp() {
		Driver.getDriver();
		System.out.println("Successful Open Browser");

	}

	@BeforeMethod
	public void beforeTest() {
		loginPage = new AccountPageObj();
		loginPage.clickAccBtn();

	}

	@Test
	public void TC001_LoginWithValidUsernameAndPassword() {
		loginPage.inputValidEmailAndPassword();
		loginPage.loginVerify();
		loginPage.clickOnSignOutBtn();
	}

	@Test
	public void TC002_LoginWithIncorrectUsernameAndIncorrectPassword() {
		loginPage.inputInvalidLogin();
		loginPage.varifyInvalidUsernameMessage();
	}

	@Test
	public void TC003_LoginWithCorrectUsernameAndEmptyPassword() {
		loginPage.inputEmptyPasswordLogin();
		loginPage.varifyEmptyPassword();
	}

	@Test
	public void TC004_LoginWithEmptyUsernameAndValidPassword() {
		loginPage.inputEmptyUsernamelogin();
		loginPage.verifyEmptyUsername();

	}

	@Test
	public void TC005_LoginWithEmptyUsernameAndEmptyPassword() {
		loginPage.inputEmpty();
		loginPage.verifyEmptyUsername();

	}

	@Test
	public void TC006_LoginPasswordShouldBeMasked() {
		loginPage.inputCharacterPassword();
		loginPage.verifyPasswordBeMasked();

	}

	@Test
	public void TC007_LoginHandlesCaseSensitive() {
		loginPage.inputCaseSensitive();
		loginPage.varifyInvalidUsernameMessage();

	}

	@Test
	public void TC008_LoginAuthentication() {
		loginPage.inputValidEmailAndPassword();
		loginPage.loginVerify();
		loginPage.clickOnSignOutBtn();
		Driver.navBack();
		loginPage.verifyLabel();
		Driver.getURL();
	}

	@AfterClass
	public void Destroy() {
		Driver.destroy();
	}
}
