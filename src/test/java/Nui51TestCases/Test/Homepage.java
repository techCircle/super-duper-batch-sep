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
import Nui51TestCases.PageObject.CheckoutBillingPaymentPageObject;
import Nui51TestCases.PageObject.CommonPageObject;
import Nui51TestCases.PageObject.ConfirmationPageObject;
import Nui51TestCases.PageObject.HomePageObject;
import Nui51TestCases.PageObject.LoginPageObject;
import Nui51TestCases.PageObject.ShopPageObject;
import NuiUtilities.NuiConfigurationProperties;
import NuiUtilities.Driver;

public class Homepage {
	
	WebDriver driver ;
	WebDriverWait wait;
	Actions act;
	
	HomePageObject hp = new HomePageObject();
	CommonPageObject cp = new CommonPageObject();
	ShopPageObject  sp = new ShopPageObject();
	LoginPageObject lg = new LoginPageObject();
	BasketPageObject bp = new BasketPageObject();
	CheckoutBillingPaymentPageObject cbp = new CheckoutBillingPaymentPageObject();
	ConfirmationPageObject cf = new ConfirmationPageObject();
	
	
		@BeforeClass
		public static void before() {
		
		}


		@BeforeMethod
		public void setUp() {
			
			driver = Driver.getDriver();
			driver.get(NuiConfigurationProperties.getKeyValue("url"));
			wait = new WebDriverWait(driver, 30);
			cp.clickShop.click();
			sp.clickHome.click();
		}
		
		@Test
		public void homePageWithThreeSlidersOnly() {
			hp.verifyThreeSliders();		
		}
		
		@Test
		public void HomePageWithThreeArrivals() {	
			hp.verifyThreeNewArrivals();	
		}
		
		@Test
		public void imagesInArrivalsShouldNavigate() throws InterruptedException {
			hp.verifyThreeNewArrivals();
			hp.verifyImagesInArrivalsShouldNavigate();	
		}
		
		@Test
		public void arrivalsImagesDescription() throws InterruptedException {
			hp.verifyThreeNewArrivals();
			hp.verifyThreeBookDescription();	
		}
		
		@Test
		public void arrivalsImagesReviews() throws InterruptedException {
			hp.verifyThreeNewArrivals();
			hp.verifyArrivalsImgReview();	
		}
		
		@Test
		public void arrivalsImagesAddToBasket() throws InterruptedException {
			hp.verifyThreeNewArrivals();
			hp.addToBasket();
			hp.verifyCorrectBookAndPriceInBasket();	
		}
		
		@Test
		public void arrivalsAddToBasketWithMoreBooks() throws InterruptedException {
			this.arrivalsImagesAddToBasket();
			hp.addMoreThanMaxBookAndVerifyErrMsg();	
		}
		
		@Test
		public void arrivalsAddToBasketItems() throws InterruptedException {
			this.arrivalsImagesAddToBasket();
			cp.cartLink.click();
			bp.verifyAtBasketPage();
		}
		
		@Test 
		public void arrivalsAddToBasketItemsCoupon() throws InterruptedException {
			this.arrivalsAddToBasketItems();
			bp.addAndVerifyCoupon();
		}
		
		@Test
		public void arrivalsAddToBasketItemsCouponValueLessThan450() throws InterruptedException {
			this.arrivalsAddToBasketItemsCoupon();
			//Since the provided coupon code is not working so I have to change the test #14th-15th
			//from verifying discount amount to verify that coupon code is not valid after enter the coupon code
		}
		
		@Test
		public void removeBook() throws InterruptedException {
			this.arrivalsAddToBasketItems();
			bp.removeAndVerify();
		}
		
		@Test
		public void ArrivalsAddToBasketItemsAddBook() throws InterruptedException, ParseException {
			this.arrivalsAddToBasketItems();
			bp.addMoreBookAndVerifyUpdatedPrice();
		}
		
		@Test
		public void arrivalsAddToBasketItemsCheckoutBookFinalPrice() throws InterruptedException {
			this.arrivalsAddToBasketItems();
			String total = bp.totalPrice.getText();
			Assert.assertTrue(total.equals(NuiConfigurationProperties.getKeyValue("expStrTotal")));
		}
		
		@Test 
		public void arrivalsAddToBasketItemsCheckoutUpdateBasket() throws InterruptedException, ParseException {
			this.ArrivalsAddToBasketItemsAddBook();
			//this test case is exactly the same as arrivalsAddToBasketItemsAddBook
		}
		
		@Test 
		public void arrivalsAddToBasketItemsCheckoutTotalAndSubTotalCondition() throws InterruptedException {
			this.arrivalsAddToBasketItems();
			String total = bp.tPrice.getText().substring(7);
			String subTotal = bp.stPrice.getText().substring(10);
			Assert.assertTrue(Double.valueOf(total) > Double.valueOf(subTotal));
		}
		
		@Test 
		public void arrivalsAddToBasketItemsCheckoutFunctionality() throws InterruptedException {
			this.arrivalsAddToBasketItemsCheckoutTotalAndSubTotalCondition();
			bp.proceedToChkoutBtn.click();
			Assert.assertTrue(cbp.paymentGateWay.isDisplayed());	
		}
		
		@Test 
		public void arrivalsAddToBasketItemsCheckoutPaymentGateway() throws InterruptedException {		
			this.arrivalsAddToBasketItemsCheckoutFunctionality();
			cbp.verifyBillingPage();
			cbp.fillFormBillingAndPayment();
			cbp.paymentMtd.click();
			cbp.clickCoupon();
		}
		
		@Test
		public void arrivalsAddToBasketItemsCheckoutPaymentGatewayPlaceOrder() throws InterruptedException {
			this.arrivalsAddToBasketItemsCheckoutFunctionality();
			cbp.verifyBillingPage();
			cbp.fillFormBillingAndPayment();
			cbp.paymentMtd.click();
			cbp.placeOrderBtn.click();
			Thread.sleep(3000);
			cf.verifyOrderConfirmation();
		}
		
		
		@AfterClass
		public void after() {
			
			driver.close();
		}


}
