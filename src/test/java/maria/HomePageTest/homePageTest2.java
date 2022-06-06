package maria.HomePageTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import maria.HomePage.BillingCheckoutPage;
import maria.HomePage.CheckoutPage;
import maria.HomePage.HomePagePage;
import maria.HomePage.shopPage;
import mariaUtilities.Driver;

public class homePageTest2 {
	HomePagePage hP = new HomePagePage();
	shopPage sP = new shopPage();
	CheckoutPage coP = new CheckoutPage();
	BillingCheckoutPage bCoP = new BillingCheckoutPage();
	@BeforeClass
	public void beforeclass() {
	Driver.getDriver();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException  {

		
		hP.shopButton.click();
		sP.homeButton.click();
		}
	
	
@Test(priority=0)
public void test8() throws InterruptedException  {

		hP.checkSlidersCount();
		hP.checkArrivalsCount();
		hP.verifyImagesInArrivalsShouldNavigate();

		hP.arrivalImage2click();
		Thread.sleep(3000);
		hP.arrivalImg2AddToBasket();
		hP.arrivalsubImg2CartPrice();               
		hP.arrivalSubImgProceedToCheckout();
		Thread.sleep(2000);
		coP.arrivalsubImg2CartProceedTocheckoutBtn();
	}


	@Test(priority=1)
	public void test9to11() throws InterruptedException {
		this.test8();
		coP.couponCodeEntry();
		Thread.sleep(3000);
		coP.couponCodeCondition();
		coP.removeBook();
	}

	@Test(priority=2)
	public void test12() throws InterruptedException {
		this.test8();
		coP.updateBasketCheck();
		coP.updateCart();


}

	@Test(priority=3)
	public void test13() throws InterruptedException {
		this.test8();
		coP.orderTotalChkout();
	}

	@Test(priority=4)
	public void test14() throws InterruptedException {
		this.test12();
		// This testCase is exactly same astest12

	}

	@Test(priority=5)
	public void test15() throws InterruptedException {
		this.test8();
		coP.totalSubTotalDisplay();

	}

	@Test(priority=6)
	public void test16() throws InterruptedException {
		this.test15();
		coP.arrivalsubImg2CartProceedTocheckoutBtn();
		coP.checkOutPagePayment();
	}

	@Test(priority=7)
	public void test17And18() throws InterruptedException {
		this.test16();
		bCoP.billingDetails();
		bCoP.placeOrder();

	}
	@AfterClass
	public void tearDown() {
		Driver.tearDown();
	}
}
