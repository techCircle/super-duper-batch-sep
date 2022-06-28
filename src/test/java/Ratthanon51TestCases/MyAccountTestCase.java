package Ratthanon51TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import RatthanonPageObject.AccoutDetail;
import RatthanonPageObject.HomePage;
import RatthanonPageObject.MyAccountPage;
import RatthanonUtilities.BaseClassR;
import RatthanonUtilities.Constants_ratthanon;

public class MyAccountTestCase {
  
	HomePage hp = new HomePage();
	MyAccountPage ac = new MyAccountPage();
	AccoutDetail ad = new AccoutDetail();

	@BeforeMethod
	public void beforeClass() {
		BaseClassR.getDriver();
		hp.MyAccountMenu.click();
		ac.LoginvalidUser();
	}
    
	@Test(priority = 1)
	public void MyAccoutDashBoard() {
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		hp.MyAccountMenu.click();
		Assert.assertEquals(ad.dashboarcdlink.getText(), "Dashboard");
		ad.logoutlink.click();
		
	}
	
	@Test(priority = 2)
	public void MyAccoutorder() {
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		hp.MyAccountMenu.click();
		ad.orderlink.click();
		Assert.assertTrue(ad.orderNumber.isDisplayed() && ad.orderStatus.isDisplayed() && ad.orderTotal.isDisplayed());
		ad.logoutlink.click();
		
	}
	
	@Test(priority = 3)
	public void MyAccoutorder2() {
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		hp.MyAccountMenu.click();
		ad.orderlink.click();
		Assert.assertTrue(ad.orderNumber.isDisplayed() && ad.orderStatus.isDisplayed() && ad.orderTotal.isDisplayed());
		ad.viewButton.click();
		Assert.assertTrue(ad.productName.isDisplayed() && ad.Email.getText().contains(Constants_ratthanon.username) && ad.address.getText().contains(Constants_ratthanon.address));
		ad.logoutlink.click();
		
	}
	
	@Test(priority = 4)
	public void MyAccoutorder3() {
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		hp.MyAccountMenu.click();
		ad.orderlink.click();
		Assert.assertTrue(ad.orderNumber.isDisplayed() && ad.orderStatus.isDisplayed() && ad.orderTotal.isDisplayed());
		ad.viewButton.click();
		Assert.assertTrue(ad.ordernumerText.isDisplayed() && ad.orderStatusText.isDisplayed() && ad.orderDateText.isDisplayed());
		ad.logoutlink.click();
		
	}
	
	@Test(priority = 5)
	public void MyAccoutAddressFunctional() {
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		hp.MyAccountMenu.click();
		ad.addresslink.click();
		Assert.assertTrue(ad.billingAddress.getText().contains(Constants_ratthanon.address) && ad.shippingAddress.getText().contains(Constants_ratthanon.address));
		ad.logoutlink.click();
		
	}
	
	@Test(priority = 6)
	public void MyAccoutAddressFunctional2() {
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		hp.MyAccountMenu.click();
		ad.addresslink.click();
		ad.ShippingeditButton.click();
		ad.inputZipCode.clear();
		ad.inputZipCode.sendKeys(Constants_ratthanon.zipcode);
		ad.buttonSaveAddress.click();
		Assert.assertEquals(ad.ChangeAddressPassed.getText(), Constants_ratthanon.changeAddressMessage);
		ad.logoutlink.click();
		
	}
	
	@Test(priority = 7)	
	public void MyAccoutAccoutDetail() {
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		hp.MyAccountMenu.click();
        ad.AccoutDetailsLink.click();
        ad.verifyChangePassWord();
		ad.logoutlink.click();
		
	}
	
	@Test(priority = 8)
	public void MyAccoutLogout() {
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		hp.MyAccountMenu.click();
		ad.logoutlink.click();
		Assert.assertTrue(ac.loginForm.isDisplayed());
		
	}	
    
	@AfterClass
	public void afterClass() {
		BaseClassR.tearDown();
	}
	
}
