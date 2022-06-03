package victor_aut51CasesTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import victor.automationTesting.pages.MyAccountLogInPage;
import victor.automationTesting.pages.MyAccountPage;
import victor.utilities.Victor_BaseClass;

public class MyAccountRegistrationTest {

	MyAccountPage mAP = new MyAccountPage ();
	MyAccountLogInPage mALP = new MyAccountLogInPage ();


	@BeforeMethod
    public void setUp() {
		Victor_BaseClass.getDriver();
		mAP.myAccount.click();
	}
	
	@Test(priority= 1, enabled = true)
	public void RegistrationSignIn () {
		mAP.registrationSignIn();	
		mALP.logOut.click();
	}
	
	@Test(priority= 2, enabled = true)
	public void RegistrationWithInvalidEmailId () {
		mAP.registrationInvalidEmail();	
	}
	
	@Test(priority= 3, enabled = true)
	public void RegistrationWithEmpyEmailId () {
		mAP.registrationEmpyEmail();	
	}
	
	@Test(priority= 4, enabled = true)
	public void RegistrationWithEmpyPassword () {
		mAP.registrationEmpyPassword();
	}
	
	@Test(priority= 5, enabled = true)
	public void RegistrationWithEmptyEmailIdAndPassword () {
		mAP.registrationEmpyEmailandPAssword();
	}
	
	@AfterMethod
	 public void tearDown() {
	   Victor_BaseClass.tearDown();
	 }

}
