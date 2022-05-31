package EmmieTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Emmie_Utilities.Driver;
import Emmie_automationTestingPage.LoginPage;
import Emmie_automationTestingPage.MyAccountPage;
import Emmie_automationTestingPage.ShopPage;

public class MyAccountTest {
	ShopPage sP = new ShopPage();
	LoginPage lP = new LoginPage();
	MyAccountPage accP = new MyAccountPage();

	@BeforeClass
	public void setUp() {

		Driver.getDriver();
	}

	@BeforeMethod
	public void beforeTest() {
		sP.myAccBtnClick();
		lP.validEmailInput();
		lP.validPasswordInput();
		lP.loginBoxClick();
	}

	@Test(priority = 1)
	public void myAccountsDashboard() {
		accP.dashboardClick();
	}

	@Test(priority = 2)
	public void myAccountsOrdersClick() {
		accP.orderClick();

	}

//	@Test
//	public void myAccountsOrdersDetails() {
//		
//	}
//
//	@Test
//	public void myAccountsStatus() {
//
//	}
//
	@Test(priority = 3)
	public void myAccountAddressFunctionality() {

		accP.addressClick();
	}
//
//	@Test
//	public void myAccountsAddressFunctionality() {
//	}
//
//	@Test
//	public void myAccountsAccountDetails() {
//	}
//
//	@Test
//	public void myAccountsLogOut() {
//	}

	@AfterClass
	public void tearDown() {
		Driver.tearDown();
	}
}
