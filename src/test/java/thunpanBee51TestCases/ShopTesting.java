package thunpanBee51TestCases;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import thunpanBee51TestCasesPageObj.ProductPageObj;
import thunpanBee51TestCasesPageObj.ShopObjPage;

public class ShopTesting {

	private ShopObjPage shop;
	private ProductPageObj productPage;

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
	}

//	@Test
//	public void TC011_ShopAddToBasketViewBasketThroughItemLink() {
//
//	}
//
//	@Test
//	public void TC012_ShopAddToBasketViewBasketTaxFunctionality() {
//
//	}

}
