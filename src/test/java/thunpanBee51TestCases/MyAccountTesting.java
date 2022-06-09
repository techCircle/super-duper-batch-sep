package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTesting extends PageInitialized {

	@BeforeClass
	public void setUp() {
		Driver.getDriver();
		System.out.println("Successful Open Browser");
	}

	@BeforeMethod
	public void setUpBeforeMethod() {
		accPage.clickAccBtn();
		accPage.inputValidEmailAndPassword();

	}

	@Test
	public void TC001_MyAccountsDashboard() {
		accPage.clickAccBtn();
		accPage.verifyDashBoard();
		accPage.clickLogOut();

	}

	@Test
	public void TC002_AccountsOrders() {
		accPage.clickAccBtn();
		accPage.clickOrderLink();
		accPage.verifyOrderSessionDisplay();
		accPage.clickLogOut();
	}

	@Test
	public void TC003_AccountsOrders() {
		accPage.clickAccBtn();
		accPage.clickOrderLink();
		accPage.clickviewBtn();
		accPage.Detail.isDisplayed();
		accPage.clickLogOut();
	}

	@Test
	public void TC004_AccountsOrders() {
		accPage.clickAccBtn();
		accPage.clickOrderLink();
		accPage.clickviewBtn();
		accPage.orderStatus.isDisplayed();
		accPage.clickLogOut();
	}

	@Test
	public void TC005_AccountsAddressFunctionality() {
		accPage.clickAccBtn();
		accPage.clickAddressLink();
		accPage.Detail.isDisplayed();
		accPage.clickLogOut();
	}

	@Test
	public void TC006_AccountsAddressFunctionality() {
		accPage.clickAccBtn();
		accPage.clickAddressLink();
		accPage.clickShippingEditLink();
		accPage.Detail.isDisplayed();
		accPage.clickLogOut();

	}

	@Test
	public void TC007_MyAccountsAccountDetails() {
		accPage.clickAccBtn();
		accPage.clickAccDetail();
		accPage.Detail.isDisplayed();
		accPage.clickLogOut();
	}

	@Test
	public void TC008_MyAccountsLogOut() {
		accPage.clickAccBtn();
		accPage.clickLogOut();
		accPage.loginForm.isDisplayed();
	}

	@AfterClass
	public void destroy() {
		Driver.destroy();
	}

}
