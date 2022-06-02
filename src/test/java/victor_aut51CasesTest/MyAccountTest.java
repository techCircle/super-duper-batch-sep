package victor_aut51CasesTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import victor.utilities.Victor_BaseClass;
import victor.utilities.Victor_Constants;
import victor.automationTesting.pages.EditAddressPage;
import victor.automationTesting.pages.MyAccountLogInPage;
import victor.automationTesting.pages.MyAccountPage;
import victor.automationTesting.pages.OrdersPage;

public class MyAccountTest {
	MyAccountPage mAP = new MyAccountPage ();
	MyAccountLogInPage mALP = new MyAccountLogInPage ();
	OrdersPage oP = new OrdersPage ();
	EditAddressPage eAP = new EditAddressPage ();
	
	
	@BeforeMethod
	public void setUp() {
	Victor_BaseClass.getDriver();
	mAP.myAccount.click();
	mAP.loginWithValidUserAndPAssword();
	mAP.myAccount.click();
	}
	
	
	@Test(priority= 1, enabled = false)
	public void MyAccountsDashboard () {
		mALP.dashboard.click();
		Assert.assertTrue(mALP.dashboardsite.getText().contains("dashboard"));
		mALP.logOut.click();
		
	}
	

	@Test(priority= 2, enabled = false)
	public void MyAccountsOrders () {
		mALP.orders.click();
		Assert.assertTrue(Victor_BaseClass.driver.getCurrentUrl().contains("orders"));
		mALP.logOut.click();
	}
	
	@Test(priority= 3, enabled = false)
	public void MyAccountsOrdersDetails () {
		mALP.orders.click();
		mALP.viewButton.click();
		oP.orderVerification();
		mALP.logOut.click();
	}
	
	@Test(priority= 4, enabled = false)
	public void MyAccountsOrdersStatus () {
		mALP.orders.click();
		mALP.viewButton.click();
		Assert.assertTrue(oP.orderStatus.getText().equals(Victor_Constants.orderStatusMessage));
		mALP.logOut.click();
	}
	
	@Test(priority= 5, enabled = true)
	public void MyAccountsAddressFunctionality () {
		mALP.addresses.click();
		eAP.addressVerification();
		mALP.logOut.click();
	}
	
	
	
	
	
	@AfterMethod
	 public void tearDown() {
	   Victor_BaseClass.tearDown();
	 }
		




}

//6. My Accounts-Address Functionality
//7. My Accounts-Account Details
//8. My Accounts-Log-Out
