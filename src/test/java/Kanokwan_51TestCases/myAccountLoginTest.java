package Kanokwan_51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import KanokwanObject.myAccountLonginPage;
import KanokwanUtilities.KanokwanBaseClass;

public class myAccountLoginTest {
	
	myAccountLonginPage alp = new myAccountLonginPage();
	
	@BeforeClass
	public void setUp() {
		KanokwanBaseClass.getDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
  
		alp.myAccount();
  
}

	//MY ACCOUNT - LOGIN
	// 1. Log-in with valid username and password.
	@Test(priority = 1)
	public void loginWithValidUsernameAndPassword() {

		
		alp.valid_userName_login();
		alp.valid_password_login();
		alp.loginButton();
		alp.verifyLogin();
		alp.signOutButton();

}

	//2. Log-in with incorrect username and incorrect password.
	@Test(priority = 2)
	public void loginWithInValidUserNameAndPassword() throws InterruptedException{
		
		alp.inValid_userName_login();
		Thread.sleep(3000);
		alp.inValid_password_login();
		Thread.sleep(3000);
		alp.loginButton();
		alp.verifyLoginError();
		
	}
	
	// 3. Log-in with correct username and empty password.
	@Test(priority = 3)
	public void loginWithCorrectUserNameAndEmptyPassword() {
		
		alp.valid_userName_login();
		alp.emptyPassword_login();
		alp.loginButton.click();
		alp.verifyLoginError();
		
	}
		
	//4. Log-in with empty username and valid password.
	@Test(priority = 4)
	public void loginWithEmptyUserNameAndValidPassword() {
				
		alp.emptyUserName_login();
		alp.valid_password_login();
		alp.loginButton.click();
		alp.verifyLoginError();
	}
		
	//5. Log-in with empty username and empty password.
	@Test(priority = 5)
	public void loginWithEmptyUserNameAndPassword() {
		
		alp.emptyUserName_login();
		alp.emptyPassword_login();
		alp.loginButton.click();
		alp.verifyLoginError();
		
	}
	
	// 6. Log-in -Password should be masked
	
	@Test(priority = 6)
	public void passwordShouldBeMasked() {
		
		alp.valid_userName_login();
		alp.valid_password_login();
		alp.verifyPasswordMasked();
	}
	
	// 7. Login-Handles case sensitive
	@Test(priority = 7)
	public void handlesCaseSensitive() {
		
		alp.changeUserName_login();
		alp.changePassword_login();
		alp.loginButton.click();
		alp.verifyLoginError();
		
	}
	
	//8. Login-Authentication
	@Test(priority = 8)
	public void authentication() {
		
		alp.valid_userName_login();
		alp.valid_password_login();
		alp.loginButton.click();
		alp.signOutButton();
		KanokwanBaseClass.driver.navigate().back();
		alp.verifySignout();
		alp.authenticationVerify();
			
	}
	
	@AfterClass
	public void tearDown() {
 
		KanokwanBaseClass.tearDown();
	}

}

