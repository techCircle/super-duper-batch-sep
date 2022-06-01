package Meena_51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MeenaObject.loginPage;
import MeenaUtilities.MeenaDriver;


public class loginTest {


	loginPage login = new loginPage();
	
	@BeforeMethod
	public void setup() {
	
		login.setup();
	
	}		
	@Test (priority=1, groups = {"Meena"} )	
	public void validUsernamePassword() {	
		
		login.inputUsername();
		login.inputPassword();
		login.loginBtn.click();
		login.signOut.click();
		login.verifyLoginText();

}
	
	@Test (priority=2, groups = {"Meena"} )	
	public void invalidUsernameInvalidPassword() {

		login.invalidUsername();
		login.invalidPassword();
		login.loginBtn.click();
		login.verifyErrorText();
	}

	@Test (priority=3, groups = {"Meena"} )	
	public void validUserNameEmptyPassword() {

		login.inputUsername();
		login.loginBtn.click();
		login.verifyErrorText();

	}
	@Test (priority=4, groups = {"Meena"} )	
	public void emptyUsernameValidPassword() {

		login.inputPassword();
		login.loginBtn.click();
		login.verifyErrorText();
	}
	@Test (priority=5, groups = {"Meena"} )	
	public void emptyUsernameEmptyPassword() {
		
		login.loginBtn.click();
		login.verifyErrorText();
	}

	@Test (priority=6, groups = {"Meena"} )	
	public void passwordBoxDisplyBullets() {

		login.verifyPasswordBoxDisplyBullets();
		login.loginBtn.click();
	}
	
	@Test (priority=7, groups = {"Meena"} )	
	public void caseChangedUsernameAndPassword() {

		login.caseChangedUsername();
		login.caseChangedPassword();
		login.loginBtn.click();
		login.verifyErrorText();
	}

	@Test (priority=8, groups = {"Meena"} )	
	public void authentication() throws InterruptedException {

		login.inputUsername();
		login.inputPassword();
		login.loginBtn.click();
		login.signOut.click();
		login.authentication();

	}
	@AfterClass
	public void tearDown() {
		MeenaDriver.tearDown();;
	}
	
	
	
	
}
