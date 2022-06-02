package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import thunpanBee51TestCasesPageObj.AccountPageObj;

public class RegistrationFunctionality {
	private AccountPageObj registerPage;

	@BeforeClass
	public void setUp() {
		Driver.getDriver();
		System.out.println("Successful Open Browser");
	}

	@BeforeMethod
	public void beforeMethod() {
		registerPage = new AccountPageObj();
		registerPage.clickAccBtn();
	}

	@Test
	public void TC001_RegistrationSignin() {
		registerPage.inputValidRegister();
		registerPage.verifyRegistration();
	}

	@Test
	public void TC002_RegistrationWithInvalidEmailId() {
		registerPage.inputInvalidRegisterEmail();
		registerPage.verifyInvalidRegistrationEmail();

	}

	@Test
	public void TC003_RegistrationWithEmptyEmailId() {
		registerPage.inputEmptyRegisterEmail();
		registerPage.verifyInvalidRegistrationEmail();
	}

	@Test
	public void TC004_RegistrationWithEmptyPassword() {
		registerPage.inputEmptyRegisterPassword();
		registerPage.verifyEmptyRegisterPassword();
	}

	@Test
	public void TC005_RegistrationWithEmptyEmailiIdAndPassword() {
		registerPage.inputEmptyRegister();
		registerPage.verifyInvalidRegistrationEmail();
	}

	@AfterClass
	public void Destroy() {
		Driver.destroy();
	}
}
