package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class RegistrationFunctionality extends PageInitialized {

	@BeforeClass
	public void setUp() {
		Driver.getDriver();
		System.out.println("Successful Open Browser");
	}

	@BeforeMethod
	public void beforeMethod() {
		accPage.clickAccBtn();
	}

	@Test
	public void TC001_RegistrationSignin() {
		accPage.inputValidRegister();
		accPage.verifyRegistration();
	}

	@Test
	public void TC002_RegistrationWithInvalidEmailId() {
		accPage.inputInvalidRegisterEmail();
		accPage.verifyInvalidRegistrationEmail();

	}

	@Test
	public void TC003_RegistrationWithEmptyEmailId() {
		accPage.inputEmptyRegisterEmail();
		accPage.verifyInvalidRegistrationEmail();
	}

	@Test
	public void TC004_RegistrationWithEmptyPassword() {
		accPage.inputEmptyRegisterPassword();
		accPage.verifyEmptyRegisterPassword();
	}

	@Test
	public void TC005_RegistrationWithEmptyEmailiIdAndPassword() {
		accPage.inputEmptyRegister();
		accPage.verifyInvalidRegistrationEmail();
	}

	@AfterClass
	public void Destroy() {
		Driver.destroy();
	}
}
