package Nui51TestCases.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Nui51TestCases.PageObject.BasketPageObject;
import Nui51TestCases.PageObject.CheckoutBillingPaymentPageObject;
import Nui51TestCases.PageObject.CommonPageObject;
import Nui51TestCases.PageObject.ConfirmationPageObject;
import Nui51TestCases.PageObject.EditAccountPageObject;
import Nui51TestCases.PageObject.EditAddressPageObject;
import Nui51TestCases.PageObject.EditAddressShippingPageObject;
import Nui51TestCases.PageObject.HomePageObject;
import Nui51TestCases.PageObject.LoginPageObject;
import Nui51TestCases.PageObject.MyAccountPageObject;
import Nui51TestCases.PageObject.OrdersPageObject;
import Nui51TestCases.PageObject.ShopPageObject;
import Nui51TestCases.PageObject.ViewOrderPageObject;
import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyAccount {
	
	WebDriver driver;
	WebDriverWait wait;
	
	HomePageObject hp = new HomePageObject();
	CommonPageObject cp = new CommonPageObject();
	ShopPageObject  sp = new ShopPageObject();
	LoginPageObject lg = new LoginPageObject();
	BasketPageObject bp = new BasketPageObject();
	CheckoutBillingPaymentPageObject cbp = new CheckoutBillingPaymentPageObject();
	ConfirmationPageObject cf = new ConfirmationPageObject();
	MyAccountPageObject ap = new MyAccountPageObject();
	OrdersPageObject op = new OrdersPageObject();
	ViewOrderPageObject vp = new ViewOrderPageObject();
	MyAccountLogin al = new MyAccountLogin();
	EditAddressPageObject ea = new EditAddressPageObject();
	EditAddressShippingPageObject eas = new EditAddressShippingPageObject();
	EditAccountPageObject eap = new EditAccountPageObject();
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = Driver.getDriver();
		driver.get(NuiConfigurationProperties.getKeyValue("url"));
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void dashboard() {
		al.validUsernamePassword();
		ap.dashboardBtn.click();
		Assert.assertTrue(ap.dashboardMsg.getText().contains("dashboard"));
		ap.signoutBtn.click();
	}
	  
	@Test
	public void orderLink() throws InterruptedException {
		al.validUsernamePassword();
		ap.orderBtn.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("orders"));
		Assert.assertTrue(op.orderTxt.isDisplayed());
		cp.myaccountBtn.click();
		ap.signoutBtn.click();
	}
	
	@Test  
	public void orderViewButton() throws InterruptedException {
		al.validUsernamePassword();
		//go to shop to add something in the basket
		cp.clickShop.click();
		sp.programBookAddToBasketBtn.click();
		cp.myaccountBtn.click();
		ap.orderBtn.click();
		op.viewBtn.click();
		vp.verifyViewOrderPage();
		cp.myaccountBtn.click();
		ap.signoutBtn.click();
	}
	
	@Test
	public void orderViewButtonV2() throws InterruptedException {
		al.validUsernamePassword();
		cp.clickShop.click();
		sp.programBookAddToBasketBtn.click();
		cp.myaccountBtn.click();
		ap.orderBtn.click();
		op.viewBtn.click();
		vp.verifyOrderNumDateStatus();
		cp.myaccountBtn.click();
		ap.signoutBtn.click();

	}
	
	@Test
	public void addressFunctionality() {
		al.validUsernamePassword();
		ap.addressBtn.click();
		ea.verifyBillingShippingAdd();
		cp.myaccountBtn.click();
		ap.signoutBtn.click();
	}
	
	@Test 
	public void addressFunctionalityV2() throws InterruptedException {
		al.validUsernamePassword();
		ap.addressBtn.click();
		ea.verifyBillingShippingAdd();
		ea.editShippingAddBtn.click();
		eas.fillFormEditShippingAdd();
		Assert.assertTrue(ap.addChangeMsg.getText().equals(NuiConfigurationProperties.getKeyValue("addressChangeMsg")));
		cp.myaccountBtn.click();
		ap.signoutBtn.click();
	}
	
	@Test
	public void accountDetails() {
		al.validUsernamePassword();
		ap.myAccBtn.click();
		Assert.assertTrue(eap.EditPwdTxt.getText().equals(NuiConfigurationProperties.getKeyValue("newPwdChange")));
		cp.myaccountBtn.click();
		ap.signoutBtn.click();
	}
	
	@Test
	public void logout() {
		al.validUsernamePassword();
		ap.signoutBtn.click();
		Assert.assertTrue(lg.loginTxt.getText().equals(NuiConfigurationProperties.getKeyValue("loginTxt"))); 
	}
	
	@AfterClass
	public void after() {
	//	driver.close();;
	}

}
