package EmmieTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Emmie_Utilities.Driver;
import Emmie_automationTestingPage.LoginPage;
import Emmie_automationTestingPage.MyAccountPage;
import Emmie_automationTestingPage.ShopPage;

public class MyAccountLoginTest {
	ShopPage sP = new ShopPage();
	LoginPage lP = new LoginPage();
	MyAccountPage accPage = new MyAccountPage();

	@BeforeClass
	public void setUp() {
		Driver.getDriver();

	}

	@BeforeMethod
	public void beforeTest() {

		sP.myAccBtnClick();

	}

	@Test
	public void loginWithValidUsernameAndPassword() {

		lP.validEmailInput();
		lP.validPasswordInput();
		lP.loginBox.click();
		// accPage.signOutBtn.click();

	}

	@Test
	public void logiWithIncorrectUsernameAndIncorrectPassword() {

		lP.invalidEmailInput();
		lP.invalidPassword();
		lP.loginBox.click();
		lP.verifyInValidInput();

	}

	@Test
	public void loginWithCorrectUsernameAndEmptyPassword() {

		lP.validEmailInput();
		lP.emptyPasswordInput();
		lP.loginBox.click();
		lP.verifyInValidInput();

	}

	@Test
	public void loginWithEmptyUsernameAndValidPassword() {

		lP.emptyEmailInpuyt();
		lP.validPasswordInput();
		lP.loginBox.click();
		lP.verifyInValidInput();

	}

	@Test
	public void loginWithEmptyUsernameAndEmptyPassword() {

		lP.emptyEmailInpuyt();
		lP.emptyPasswordInput();
		lP.loginBox.click();
		lP.verifyInValidInput();

	}

	@Test
	public void LoginPasswordShouldbeMasked() {

	}

	@Test
	public void LoginHandlesCaseSensitive() {
		lP.caseChangeEmailInput();
		lP.caseChangePasswordInput();
		lP.loginBox.click();
		lP.verifyInValidInput();

	}

	@Test
	public void loginAuthentication() {

		lP.validEmailInput();
		lP.validPasswordInput();
		lP.loginBox.click();
		accPage.signOutBtn.click();
		Driver.getCurrentUrl();

	}

	@AfterClass
	public void tearDown() {
		Driver.tearDown();
	}
}
