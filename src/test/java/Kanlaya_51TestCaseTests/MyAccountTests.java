package Kanlaya_51TestCaseTests;

import org.testng.annotations.Test;
import Kanlaya_51TestCasePages.MyAccountLoginPage;
import Kanlaya_51TestCasePages.MyAccountPage;
import Kanlaya_51TestCasePages.HomePage;
import Kanlaya_51TestCaseUtilities.Base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MyAccountTests {

	MyAccountPage myActPage = new MyAccountPage();
	MyAccountLoginPage  loginPage = new MyAccountLoginPage();
	HomePage homePage = new HomePage();
	

	@BeforeClass 
	public void setUp() {
		Base.getDriver();
		
	}
	@BeforeMethod
	public void beforeMethod() {
		homePage.clickMyAcctBtn();
		loginPage.validLogin();
	}
	

	@Test(priority = 1)
	public void myAccountsDashboard() {
		homePage.clickMyAcctBtn();
		myActPage.clickDashBoardBtn();
		myActPage.logOut();
	}
	
	@Test(priority = 2)
	public void myAccountsOders() {
		homePage.clickMyAcctBtn();
		myActPage.clickOrdersBtn();
		myActPage.logOut();
		
	}
	
	@Test(priority = 3)
	public void myAccountsOder_Customer_BillingAddess_Details() {
		homePage.clickMyAcctBtn();
		myActPage.clickOrdersBtn();
		myActPage.clickViewBtn();
		myActPage.verifyOrderDetails();
		myActPage.verifyCustomerDetails();
		myActPage.verifyBillingAdrressDetails();
		homePage.clickMyAcctBtn();
		myActPage.logOut();
	}
	
	@Test(priority = 4)
	public void viewAccountViewOrderNumber_StatusOrder() {
		homePage.clickMyAcctBtn();
		myActPage.clickOrdersBtn();
		myActPage.clickViewBtn();
		myActPage.verifyOrderDateAndStatus();	
		myActPage.logOut();
	}

	@Test(priority = 5)
	public void myAccountAddressFunctionality() {
		homePage.clickMyAcctBtn();
		myActPage.clickAddressBtn();
		myActPage.verifyBillingAddressText();
		myActPage.verifyShippingAddessText();
		myActPage.logOut();
		
	}
	
	
	@Test(priority = 6)
	public void myAccountEditShippingAddressFunctionality() throws InterruptedException {
		homePage.clickMyAcctBtn();
		myActPage.clickAddressBtn();
		myActPage.clickShippingEditBtn();
		myActPage.verifyMyAccountEditShippingAddressFunctionallity();
		myActPage.verifyShippingAddressChangedSuccess();
		homePage.clickMyAcctBtn();
		myActPage.logOut();
		
	}
	
	@Test(priority = 9)
	public void accountDetails() {
		homePage.clickMyAcctBtn();
		myActPage.clickAccountDetailsBtn();
		myActPage.accountDetails();
		myActPage.logOut();
		
	}
	
	@Test(priority = 10)
	public void logOut() {
		myActPage.logOut();
	}


	@AfterClass
	public void tearDown() {
		Base.teardown();
		
		
	}

}
