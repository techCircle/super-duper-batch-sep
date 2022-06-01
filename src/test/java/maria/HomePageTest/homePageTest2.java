package maria.HomePageTest;

import org.testng.annotations.Test;

import Utilities.Driver;
import maria.HomePage.BillingCheckoutPage;
import maria.HomePage.CheckoutPage;
import maria.HomePage.HomePagePage;
import maria.HomePage.shopPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class homePageTest2 {
	HomePagePage hP = new HomePagePage();
	shopPage sP = new shopPage();
	CheckoutPage coP=new CheckoutPage();
	BillingCheckoutPage bCoP=new BillingCheckoutPage();

//changes to push
	@BeforeMethod
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
		//testCase8
		hP.arrivalSubImgProceedToCheckout();
		coP.arrivalsubImg2CartProceedTocheckoutBtn();
	}
	@AfterClass
	public void tearDown() {
		Driver.tearDown();
	}

	@Test(priority=1)
	public void test9to11() throws InterruptedException {



		coP.couponCodeEntry();
		Thread.sleep(3000);
		coP.couponCodeCondition();		
		coP.removeBook();
	}


	@Test(priority=2)  //test12
	public void test12() throws InterruptedException {

		coP.updateBasketCheck();
		coP.updateCart();	
	}
	
	@Test (priority=3) 
	public void test13() {
		coP.orderTotalChkout();
	}

	@Test(priority=4)  
	public void test14() throws InterruptedException {
		this.test12();
		//This testCase is exactly same astest12

	}

	@Test(priority=5)  
	public void test15() throws InterruptedException {
		coP.totalSubTotalDisplay();


	}

	@Test(priority=6)  
	public void test16() throws InterruptedException {
		this.test15();					
		coP.arrivalsubImg2CartProceedTocheckoutBTn.click();
		coP.checkOutPagePayment();
	}



	@Test(priority=7) 
	public void test17And18() throws InterruptedException {
		this.test16();
		bCoP.billingDetails();
		bCoP.placeOrder();

	}		






}
