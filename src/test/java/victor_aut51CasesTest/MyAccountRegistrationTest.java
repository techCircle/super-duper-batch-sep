package victor_aut51CasesTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import victor.utilities.Victor_BaseClass;
import victor.automationTesting.pages.MyAccountLogInPage;
import victor.automationTesting.pages.MyAccountPage;

public class MyAccountRegistrationTest {

	MyAccountPage mAP = new MyAccountPage ();
	MyAccountLogInPage mALP = new MyAccountLogInPage ();


	@BeforeMethod
    public void setUp() {
		Victor_BaseClass.getDriver();
		mAP.myAccount.click();
	}
	
	@Test(priority= 1, enabled = false)
	public void RegistrationSignIn () {
		mAP.registrationSignIn();	
		mALP.logOut.click();
	}
	
	@Test(priority= 2, enabled = false)
	public void RegistrationWithInvalidEmailId () {
		mAP.registrationInvalidEmail();	
	}
	
	@Test(priority= 3, enabled = false)
	public void RegistrationWithEmpyEmailId () {
		mAP.registrationEmpyEmail();	
	}
	
	@Test(priority= 4, enabled = false)
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
