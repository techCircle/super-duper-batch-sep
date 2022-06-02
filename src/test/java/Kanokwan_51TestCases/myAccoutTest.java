package Kanokwan_51TestCases;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import KanokwanObject.myAccountPage;
import KanokwanUtilities.KanokwanBaseClass;

public class myAccoutTest {
	
	myAccountPage ap = new myAccountPage();
	
	@BeforeClass
	public void setUp() {
		KanokwanBaseClass.getDriver();
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		ap.myAccount();
		
	}
	
	@Test(priority = 1)
	public void myAccount_Dashboard() throws InterruptedException {
		
		ap.valid_userName_login();
		Thread.sleep(3000);
		ap.valid_password_login();
		Thread.sleep(3000);
		ap.loginButton();
		ap.dashBoardButton();
		Thread.sleep(3000);
		ap.verifyDashBoard();
  }
	
	@Test(priority = 2)
	public void myAccount_Orders() {
		
		ap.orderButton();
		ap.verifyOrdersText();
  }
	
	@Test(priority = 3)
	public void myAccount_AddressFunctionality() {
		
		ap.addressButton();
		ap.verifyAddressText();
	}
	
	@Test(priority = 4)
	public void myAccount_AddressFunctionality_Edit() throws InterruptedException {
		
		ap.addressButton();
		ap.shippingAddressButton();
		Thread.sleep(3000);
		ap.verifyShippingAddressText();
	}
	
	@Test(priority = 5)
	public void myAccount_AccountDetails() {
		
		ap.accountDetailsButton();
		ap.verifyAccountDetailsText();
	}
	
	@Test(priority = 6)
	public void myAccount_Logout() throws InterruptedException {
		
		ap.logOutButton();
		ap.verifyLogOutText();
		
	}
	
	@AfterClass
	public void tearDown() {
 
		KanokwanBaseClass.tearDown();
	}

}
