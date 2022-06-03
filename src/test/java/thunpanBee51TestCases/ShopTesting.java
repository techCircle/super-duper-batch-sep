package thunpanBee51TestCases;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import thunpanBee51TestCasesPageObj.BasketObj;
import thunpanBee51TestCasesPageObj.CheckoutPageObj;
import thunpanBee51TestCasesPageObj.OrderRecievedObj;
import thunpanBee51TestCasesPageObj.ProductPageObj;
import thunpanBee51TestCasesPageObj.ShopObjPage;

public class ShopTesting {

	private ShopObjPage shop;
	private ProductPageObj productPage;
	private BasketObj basketPage = new BasketObj();
	private CheckoutPageObj coPage = new CheckoutPageObj();
	private OrderRecievedObj orderRecieved = new OrderRecievedObj();


	@BeforeClass
	public void setUp() {
		Driver.getDriver();
		System.out.println("Successful Open Browser");
	}

	@BeforeMethod
	public void beforeTest() {
		shop = new ShopObjPage();
		productPage = new ProductPageObj();
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
	public void TC010_ShopAddToBasketViewBasketFunctionality() {
		shop.addProduct();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();
		basketPage.clickCheckout();
		coPage.verifyBillinLabelAndForm();
		coPage.formFillIn();// have to change email every executed//
		coPage.clickPlaceOrder();
		orderRecieved.verifyOrderConfirm();
		
	}

	@Test
	public void TC011_ShopAddToBasketViewBasketThroughItemLink() {
		shop.addProduct();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();
		basketPage.clickCheckout();
		coPage.verifyBillinLabelAndForm();
		coPage.formFillIn();// have to change email every executed//
		coPage.clickPlaceOrder();
		orderRecieved.verifyOrderConfirm();
	}

	@Test
	public void TC012_ShopAddToBasketViewBasketTaxFunctionality() {
		shop.addProduct();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();
		basketPage.clickCheckout();
		coPage.compareTax();
		coPage.compareTax2();
		
	}

	
	
	
		
	
}












