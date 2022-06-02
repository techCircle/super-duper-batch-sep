package maria.HomePageTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

//changes to pushzzz
	@BeforeClass
	public void setUp() throws InterruptedException {

		Driver.getDriver();
		hP.shopButton.click();
		sP.homeButton.click();
		hP.checkSlidersCount();
		hP.checkArrivalsCount();
		hP.verifyImagesInArrivalsShouldNavigate();
		hP.arrivalImage2click();
		Thread.sleep(3000);
		hP.arrivalImg2AddToBasket();
		hP.arrivalsubImg2CartPrice();

		hP.arrivalSubImgProceedToCheckout();
		coP.arrivalsubImg2CartProceedTocheckoutBtn();
	}

	@AfterClass
	public void tearDown() {
		Driver.tearDown();
	}

	@Test
	public void test9to11() throws InterruptedException {

		coP.couponCodeEntry();
		Thread.sleep(3000);
		coP.couponCodeCondition();
		coP.removeBook();
	}

	@Test
	public void test12() throws InterruptedException {

		coP.updateBasketCheck();
		coP.updateCart();
	}

	@Test
	public void test13() {
		coP.orderTotalChkout();
	}

	@Test
	public void test14() throws InterruptedException {
		this.test12();
		// This testCase is exactly same astest12

	}

	@Test
	public void test15() throws InterruptedException {
		coP.totalSubTotalDisplay();

	}

	@Test
	public void test16() throws InterruptedException {
		this.test15();
		coP.arrivalsubImg2CartProceedTocheckoutBTn.click();
		coP.checkOutPagePayment();
	}

	@Test
	public void test17And18() throws InterruptedException {
		this.test16();
		bCoP.billingDetails();
		bCoP.placeOrder();

	}

}
