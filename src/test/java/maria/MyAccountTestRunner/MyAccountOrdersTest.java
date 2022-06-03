package maria.MyAccountTestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import maria.MyAccountObjects.MyAccountPageObject;
import maria.MyAccountObjects.myAccountOrderPage;
import mariaUtilities.Driver;

public class MyAccountOrdersTest {
 
	
	MyAccountPageObject myAccount=new MyAccountPageObject();
	myAccountOrderPage myAOrder=new myAccountOrderPage();
	
	@Test
  public void myAccountDashBoard() throws InterruptedException {
		
		myAccount.clickMyAccount();
		myAOrder.orderclick();		

  }
  
	
	//changes to push
	@BeforeClass
	public void goTo() {
		Driver.getDriver();
	}

  
	
	
	@AfterClass
  public void afterMethod() {
		Driver.tearDown();;
  }

}
