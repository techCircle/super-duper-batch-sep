package Kanlaya_51TestCaseTests;

import org.testng.annotations.Test;

import Kanlaya_51TestCasePages.HomePage;
import Kanlaya_51TestCasePages.MyAccountPage;
import Kanlaya_51TestCasePages.MyAccountRegistrationPage;
import Kanlaya_51TestCaseUtilities.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MyAccountRegistrationTests {

	MyAccountRegistrationPage registerPage = new MyAccountRegistrationPage();
	MyAccountPage myActPage = new MyAccountPage();
	HomePage homePage = new HomePage();

	@BeforeClass 
	public void setUp() {
		Base.getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		homePage.clickMyAcctBtn();
	}
	
	@Test(priority = 1)
	public void validRegister() throws InterruptedException {
		
		registerPage.validRegister();
		
	}	
		
	@Test(priority = 2)
	public void registerInvalidEmailID() throws InterruptedException {
		registerPage.registerInvalidEmailID();;
	}
	
	@Test (priority = 3)
	public void registerEmptyEmail() throws InterruptedException {
		registerPage.registerEmptyEmail();
	}	
	
	
	@Test(priority = 4)
	public void registerEmptyPassword() throws InterruptedException {
		registerPage.registerEmptyPassword();
	}	
		
	@Test(priority = 5)
	public void registerEmptyEmailAndPassword() throws InterruptedException {
		registerPage.registerEmptyEmailAndPassword();
	}
	
	
		
	@AfterClass
	public void tearDown() {
		Base.teardown();
	}

}
