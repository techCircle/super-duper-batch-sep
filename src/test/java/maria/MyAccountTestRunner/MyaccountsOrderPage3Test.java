package maria.MyAccountTestRunner;

import org.testng.annotations.Test;

import Utilities.Driver;
import maria.MyAccountObjects.MyAccountPageObject;
import maria.MyAccountObjects.MyAccountsViewOrderPage;
import maria.MyAccountObjects.MyaccountsOrderPage3;
import maria.MyAccountObjects.myAccountOrderPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class MyaccountsOrderPage3Test {
	MyAccountPageObject myAccount=new MyAccountPageObject();
	myAccountOrderPage myAOrder=new myAccountOrderPage();
	MyAccountsViewOrderPage myAOrder2=new MyAccountsViewOrderPage();
	MyaccountsOrderPage3 myAOrder3=new MyaccountsOrderPage3();
	
	
	
	@Test
  public void orderStatusAndNumber() throws InterruptedException {
		myAccount.clickMyAccount();
		myAOrder.orderclick();
		myAOrder2.viewOrderDetails();
		myAOrder3.orderStatusAndnumber();	
		
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
