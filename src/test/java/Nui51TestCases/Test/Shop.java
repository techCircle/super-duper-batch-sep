package Nui51TestCases.Test;

import java.text.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Nui51TestCases.PageObject.BasketPageObject;
import Nui51TestCases.PageObject.CheckoutPageObject;
import Nui51TestCases.PageObject.CommonPageObject;
import Nui51TestCases.PageObject.ConfirmationPageObject;
import Nui51TestCases.PageObject.EditAccountPageObject;
import Nui51TestCases.PageObject.EditAddressPageObject;
import Nui51TestCases.PageObject.EditAddressShippingPageObject;
import Nui51TestCases.PageObject.HomePageObject;
import Nui51TestCases.PageObject.MyAccountPageObject;
import Nui51TestCases.PageObject.ProductCategoryPageObject;
import Nui51TestCases.PageObject.ProductPageObject;
import Nui51TestCases.PageObject.ShopPageObject;
import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class Shop {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions move;
	
	CommonPageObject cp = new CommonPageObject();
	ShopPageObject  sp = new ShopPageObject();
	ProductCategoryPageObject pcp = new ProductCategoryPageObject();
	ProductPageObject pp = new ProductPageObject();
	HomePageObject hp = new HomePageObject();
	BasketPageObject bp = new BasketPageObject();
	CheckoutPageObject chkp = new CheckoutPageObject();
	ConfirmationPageObject cf = new ConfirmationPageObject();
	MyAccountLogin lg = new MyAccountLogin();
	MyAccountPageObject ap = new MyAccountPageObject();
	EditAddressPageObject ea = new EditAddressPageObject();
	EditAddressShippingPageObject eas = new EditAddressShippingPageObject();
	EditAccountPageObject eap = new EditAccountPageObject();
	
	
	@BeforeClass
	public static void before() {
		
	}
	

	@BeforeMethod
	public void setUp() {
		
		driver = Driver.getDriver();
		driver.get(NuiConfigurationProperties.getKeyValue("url"));
		wait = new WebDriverWait(driver, 30);
		move = new Actions(driver);
	}
	
	@Test
	public void filterByPrice() throws InterruptedException {
		cp.clickShop.click();
		sp.moveSlider();
		sp.filterBtn.click();
		sp.selectByFilterAndVerify();
	}
	
	@Test
	public void productCategories() {
		cp.clickShop.click();
		sp.htmlCategoryBtn.click();
		pcp.verifyOnlyHTML();
	}
	
	@Test
	public void defaultSortingPopularity() throws InterruptedException {
		cp.clickShop.click();
		sp.sortingDropdown.click();
		Thread.sleep(2000);
		sp.selectByPopularityAndVerify();
	}
	
	@Test
	public void defaultSortingAverage() throws InterruptedException {
		cp.clickShop.click();
		sp.sortingDropdown.click();
		Thread.sleep(2000);
		sp.selectByRatingAndVerify();
	}
	
	@Test
	public void defaultSortingNewness() throws InterruptedException {
		cp.clickShop.click();
		sp.sortingDropdown.click();
		Thread.sleep(2000);
		sp.selectByNewnessAndVerify();
	}
	
	@Test
	public void defaultSortingPriceLowToHigh() throws InterruptedException {
		cp.clickShop.click();
		sp.sortingDropdown.click();
		Thread.sleep(2000);
		sp.selectByLowToHighAndVerify();
	}
	
	@Test
	public void defaultSortingPriceHighToLow() throws InterruptedException {
		cp.clickShop.click();
		sp.sortingDropdown.click();
		Thread.sleep(2000);
		sp.selectByHighToLowAndVerify();
	}
	
	@Test
	public void readMore() {
		cp.clickShop.click();
		sp.clickHome.click();
		hp.readMoreBtn.click();
		pp.verifyOutOfStock();		
	}
	
	@Test
	public void sale() {
		cp.clickShop.click();
		sp.saleBook.click();
		pp.verifySalePrice();
	}
	
	@Test
	public void addToBasketViewBasket() throws InterruptedException {
		cp.clickShop.click();
		sp.buyBook.click();
		Thread.sleep(3000);
		sp.verifyItemAndPriceInCart();
		sp.viewBasketBtn.click();
		bp.verifyToTalSubTotalDisplay();
		Assert.assertTrue(Double.valueOf(bp.tPrice.getText().substring(1)) > Double.valueOf(bp.stPrice.getText().substring(1)));
		bp.proceedtoChkoutBtn.click();
		chkp.fillBillingForm();
		chkp.CashOnDeliveryPayment.click();
		chkp.placeOrderBtn.click();
		Thread.sleep(5000);
		Assert.assertTrue(cf.cfMsg.getText().equals(NuiConfigurationProperties.getKeyValue("cfOrderMsg")));
	}
	
	@Test
	public void addToBasketViewBasketThroughItemLink() throws InterruptedException {
		cp.clickShop.click();
		sp.buyBook.click();
		Thread.sleep(3000);
		sp.verifyItemAndPriceInCart();
		cp.itemLink.click();
		bp.verifyToTalSubTotalDisplay();
		Assert.assertTrue(Double.valueOf(bp.tPrice.getText().substring(1)) > Double.valueOf(bp.stPrice.getText().substring(1)));
		bp.proceedtoChkoutBtn.click();
		chkp.fillBillingForm();
		chkp.CashOnDeliveryPayment.click();
		chkp.placeOrderBtn.click();
		Thread.sleep(5000);
		Assert.assertTrue(cf.cfMsg.getText().equals(NuiConfigurationProperties.getKeyValue("cfOrderMsg")));
	}
	
	@Test 
	public void addToBasketViewBasketTax() throws InterruptedException, ParseException {
		lg.validUsernamePassword();
		ap.addressBtn.click();
		ea.editShippingAddBtn.click();
		eas.fillFormEditShippingAdd();
		cp.clickShop.click();
		sp.buyBook.click();
		Thread.sleep(3000);
		cp.itemLink.click();
		bp.verifyToTalSubTotalDisplay();
		bp.totalMoreThanSubTotal();
		bp.checkUSTax();
		cp.myaccountBtn.click();
		ap.addressBtn.click();
		ea.editShippingAddBtn.click();
		Thread.sleep(3000);
		eas.fillFormEditShippingIndiaAdd();
		Thread.sleep(2000);
		cp.itemLink.click();
		bp.checkIndianTax();
	}
	
	@AfterClass
	public void after() {
		
		driver.quit();
	}

}
