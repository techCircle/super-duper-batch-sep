package maria.MyAccountTestRunner;

import org.testng.annotations.Test;

import Utilities.Driver;
import maria.MyAccountObjects.MyAccountDashBoardPage;
import maria.MyAccountObjects.MyAccountPageObject;
import maria.MyAccountObjects.MyAccountsEditAddressPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class MyAccountsAddressfunctionalityTest {
	MyAccountPageObject myAccount=new MyAccountPageObject();
	MyAccountsEditAddressPage myAddresFunc=new MyAccountsEditAddressPage();
	MyAccountDashBoardPage mapdash=new MyAccountDashBoardPage();
	@Test
  public void addressFunctionalityTest() throws InterruptedException {
		myAccount.clickMyAccount();
		
		Thread.sleep(3000);
		myAddresFunc.verifyingbillingAndshipAddress();
  }
  
	//changes to push
	@BeforeMethod
  public void beforeMethod() {
		Driver.getDriver();
  }

  
	
	@AfterMethod
  public void afterMethod() {
		Driver.tearDown();
  }

}
