package maria.MyAccountTestRunner;

import org.testng.annotations.Test;

import Utilities.Driver;
import maria.MyAccountObjects.MyAccountPageObject;
import maria.MyAccountObjects.MyAccountsViewOrderPage;
import maria.MyAccountObjects.myAccountOrderPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class MyAccountsOrderPage2Test {
	MyAccountPageObject myAccount=new MyAccountPageObject();
	myAccountOrderPage myAOrder=new myAccountOrderPage();
	MyAccountsViewOrderPage myAOrder2=new MyAccountsViewOrderPage();
	
	
	
	@Test
  public void viewAndVerifyDetails() {
		
		myAccount.clickMyAccount();
		myAOrder.orderclick();
		myAOrder2.viewOrderDetails();
		//changes to push	
		
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
