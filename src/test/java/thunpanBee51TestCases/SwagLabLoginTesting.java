package thunpanBee51TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import thunpanBeePageObj.CartPage;
import thunpanBeePageObj.CheckOutCompletePage;
import thunpanBeePageObj.CheckOutOverViewPage;
import thunpanBeePageObj.CheckOutPage;
import thunpanBeePageObj.ProductPage;
import thunpanBeePageObj.loginPage;

public class SwagLabLoginTesting {
	// https://www.saucedemo.com/ //

	loginPage lp = new loginPage();
	ProductPage productPage = new ProductPage();
	CartPage cartPage = new CartPage();
	CheckOutPage checkoutPage = new CheckOutPage();
	CheckOutOverViewPage checkOutOV = new CheckOutOverViewPage();
	CheckOutCompletePage checkoutComplete = new CheckOutCompletePage();

	@BeforeClass
	public void setUp() {
		Driver.getDriver();
	}

	@Test
	public void TC001_doLogin() {
		lp.doLogin();
	}

	@Test
	public void TC002_verifyProductList() {
		productPage.verifyPruductList();
	}

	@Test
	public void TC003_addItemTocart() {
		productPage.clickOnProduct();

	}

	@Test
	public void TC004_verifyItemList() {
		cartPage.verifyItemList();
	}

	@Test
	public void TC005_verifyNavigateToCheckoutPage() {
		checkoutPage.verifyToNextPage();
	}

	@Test
	public void TC006_formInput() {
		checkoutPage.formInput();
	}

	@Test
	public void TC007_verifyCheckoutTitle() {
		checkOutOV.verifyCheckOutTitle();
	}

	@Test
	public void TC008_verifySumaryInfo() {
		checkOutOV.verifySumaryInfo();
	}

	@Test
	public void TC009_verifyCompleteCheckout() {
		checkoutComplete.completeCheckOut();
	}

//		@AfterMethod
//		public void tearDown() {
//			Driver.destroy();
//		}
}
