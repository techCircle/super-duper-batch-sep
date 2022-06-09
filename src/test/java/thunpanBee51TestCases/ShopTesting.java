package thunpanBee51TestCases;

import java.text.ParseException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ShopTesting extends PageInitialized {

	@BeforeClass
	public void setUp() {
		Driver.getDriver();
		System.out.println("Successful Open Browser");
	}

	@BeforeMethod
	public void beforeTest() {
		shop.clickShopBtn();
	}

	@Test
	public void TC001_ShopFilterByPriceFunctionality() {
		shop.adjSliderPrice();
		shop.verifyPrice();

	}

	@Test
	public void TC002_ShopProductCategoriesFunctionality() {
		shop.clickOnProductCatagoryOption();
		shop.verifyCategoryProuct();
	}

	@Ignore
	@Test
	public void TC003_TO_TC007_sortingFunctionality() {
		shop.sorting();
	}

	@Test
	public void TC003_ShopDefaultSortingFunctionality() {
		shop.selectSorting();
		shop.verifyProductLabel();
	}

	@Test
	public void TC004_ShopDefaultSortingFunctionality() {
		shop.selectSortingAvg();
		shop.verifyProductLabel();
	}

	@Test
	public void TC005_ShopDefaultSortingFunctionality() {
		shop.selectSortingNew();
		shop.verifyProductLabel();
	}

	@Test
	public void TC006_ShopDefaultSortingFunctionality() {
		shop.selectSortingLow();
		shop.verifyProductLabel();
	}

	@Test
	public void TC007_ShopDefaultSortingFunctionality() {
		shop.selectSortingHigh();
		shop.verifyProductLabel();
	}

	@Test
	public void TC008_ShopReadMoreFunctionality() {
		shop.selectSortingNew();
		shop.readMore();
		productPage.verifyOutOfStock();
	}

	@Test
	public void TC009_ShopSaleFunctionality() {
		shop.onSaleSelect();
		productPage.verifyOgAndSalePrice();
	}

	@Test
	public void TC010_ShopAddToBasketViewBasketFunctionality() throws InterruptedException {
		shop.addProduct();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();
		basketPage.clickCheckout();
		coPage.verifyBillinLabelAndForm();
		coPage.formFillIn();
		coPage.clickPlaceOrder();
		orderRecieved.verifyOrderConfirm();

	}

	@Test
	public void TC011_ShopAddToBasketViewBasketThroughItemLink() throws InterruptedException {
		shop.addProduct();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();
		basketPage.clickCheckout();
		coPage.verifyBillinLabelAndForm();
		coPage.formFillIn();
		coPage.clickPlaceOrder();
		orderRecieved.verifyOrderConfirm();
	}

	@Test
	public void TC012_ShopAddToBasketViewBasketTaxFunctionality() throws InterruptedException, ParseException {
		shop.addProduct();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();
		basketPage.clickCheckout();
		coPage.roamingTax();
		coPage.indianTax();

	}

	@AfterClass
	public void tearDown() {
		Driver.destroy();
	}
}
