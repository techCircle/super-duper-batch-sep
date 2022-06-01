package Kanlaya_51TestCaseTests;

import org.testng.annotations.Test;

import Kanlaya_51TestCasePages.HomePage;
import Kanlaya_51TestCasePages.MyAccountLoginPage;
import Kanlaya_51TestCaseUtilities.Base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class MyAccountLoginTests {
	
	MyAccountLoginPage loginPage = new MyAccountLoginPage();
	HomePage homePage = new HomePage();
	
	
	@BeforeClass 
	public void setUp() {
		Base.getDriver();
		
	}
	@BeforeMethod
	public void beforeMethod() {
		homePage.clickMyAcctBtn();
	}
	
	@Test
	public void LoginWithValidUsernameAndPassword() {
		loginPage.validLogin();
	}
	
	@Test
	public void LoginWithIncorrectUsernameAndIncorrectPassword() {
		loginPage.incorrectUsernameIncorrectPassword();
	}
	@Test
	public void LoginWithCorrectUsernameAndEmptyPassword() {
		loginPage.correctUsernameEmptyPassword();
	}
	
	@Test
	public void LoginWithEmptyUsernameAndValidPassword() {
		loginPage.emptyUsernamecorrectPassword();
	}
	
	@Test
	public void LoginWithEmptyUsernameAndEmptyPassword() {
		loginPage.emptyUsernameEmptyPassword();
	}
	
  @Test
  public void LoginPasswordShouldBeMasked() {
	  loginPage.verifyPasswordShouldBeMasked();
  }
  
  @Test
  public void LoginHandlesCaseSensitive() {
	  loginPage.verifyCaseSensitive();
  }
  
  @Test
  public void LoginAuthentication() {
	  loginPage.verifyLoginAuthentication();
  }

  @AfterClass
  public void tearDown() {
	  Base.teardown();
  }

}
