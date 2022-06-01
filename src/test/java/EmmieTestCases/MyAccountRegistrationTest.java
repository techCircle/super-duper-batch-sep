package EmmieTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Emmie_Utilities.Emmie_Driver;
import Emmie_automationTestingPage.RegistrationPage;
import Emmie_automationTestingPage.ShopPage;

public class MyAccountRegistrationTest {
	ShopPage sP = new ShopPage();
	RegistrationPage rP = new RegistrationPage();

	@BeforeClass
	public void setUp() {
		Emmie_Driver.getDriver();

	}

	@BeforeMethod
	public void beforeTest() {

		sP.myAccBtnClick();

	}

	@Test
	public void RegistrationSignin() {
		rP.validEmailInput();
		rP.validPasswordInput();
		rP.registerBox.click();
		Emmie_Driver.getCurrentUrl();

	}

	@Test
	public void RegistrationWithInvalidEmail() {
		rP.invalidEmailInput();
		rP.validPasswordInput();
		rP.registerBox.click();
		rP.verifyErrorText();

	}

	@Test
	public void RegistrationWithEmptyEmail() {
		rP.emptyEmailInpuyt();
		rP.validPasswordInput();
		rP.registerBox.click();
		rP.verifyErrorText();

	}

	@Test
	public void RegistrationWithEmptyPassword() {
		rP.validEmailInput();
		rP.emptyPasswordInput();
		rP.registerBox.click();
		rP.verifyErrorText();

	}

	@Test
	public void RegistrationWithEmptyEmailEmptyPassword() {
		rP.emptyEmailInpuyt();
		rP.emptyPasswordInput();
		rP.registerBox.click();
		rP.verifyErrorText();

	}

	@AfterClass
	public void tearDown() {
		Emmie_Driver.tearDown();
	}
}
