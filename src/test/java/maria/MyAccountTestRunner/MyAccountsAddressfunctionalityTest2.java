package maria.MyAccountTestRunner;

import org.testng.annotations.Test;

import Utilities.Driver;
import maria.MyAccountObjects.MyAccountPageObject;
import maria.MyAccountObjects.MyAccountsEditAddressPage;
import maria.MyAccountObjects.MyAccountsEditAddressShippingPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class MyAccountsAddressfunctionalityTest2 {
  
	MyAccountPageObject map=new MyAccountPageObject();
	MyAccountsEditAddressPage myAddresFunc=new MyAccountsEditAddressPage();
	MyAccountsEditAddressShippingPage myAddresFunc2=new MyAccountsEditAddressShippingPage();
	
	
	//changes to push
	@Test
  public void editingShippingaddress() throws InterruptedException {
		map.clickMyAccount();
		myAddresFunc.verifyingbillingAndshipAddress();
		myAddresFunc2.editShippingaddress();
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  Driver.tearDown();
  }

}
