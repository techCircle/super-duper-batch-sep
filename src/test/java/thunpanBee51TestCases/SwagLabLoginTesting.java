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
